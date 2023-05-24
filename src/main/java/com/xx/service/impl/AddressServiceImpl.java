package com.xx.service.impl;

import com.xx.mapper.AddressMapper;
import com.xx.mapper.UserMapper;
import com.xx.pojo.Address;
import com.xx.pojo.User;
import com.xx.service.IAddressService;
import com.xx.service.IDistrictService;
import com.xx.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @ClassName: AddressServiceImpl
 * @Package: com.xx.service.impl
 * @Author: liu
 * @Date: 2023/5/11 22:37
 * @Version: 1.0
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private UserMapper userMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {

        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        //调用统计收货地址数量的方法
        Integer count = addressMapper.countByUid(uid);
        if (count >= maxCount) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        /*
          对address对象中的数据进行补全:省市区的名字看前端代码发现前端传递过来的省市区的name分别为:
          provinceCode,cityCode,areaCode,所以这里可以用address对象的get方法获取这三个的数据
         */
        String areaName = districtService.getNameByCode(address.getAreaCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        address.setAreaName(areaName);
        address.setCityName(cityName);
        address.setProvinceName(provinceName);

        //uid,isDefault
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;//1表示默认收货地址,0反之
        address.setIsDefault(isDefault);

        //补全四项日志
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        //调用插入收货地址的方法
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入用户的收货地址时产生未知异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address : list) {

            //address.setAid(null);
            //address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        //1.检测是否有该条收货地址数据
        Address result = addressMapper.findByAid(aid);
        if (result == null) {
            throw new AddressNotFoundException("收货地址不存在");
        }

        //2.检测当前获取到的收货地址数据的归属
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法数据访问");
        }
        //3.先将所有的收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefault(uid);
        if(rows < 1){
            throw new UpdateException("更新数据时产生未知的异常");
        }

        //4.将用户选中的地址设置为默认收货地址
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }


    }
}

