package com.xx.service;

import com.xx.pojo.Address;

import java.util.List;


/**
 * @Description: 收货地址的业务层接口
 * @ClassName: IAddressService
 * @Package: com.xx.service
 * @Author: liu
 * @Date: 2023/5/11 22:29
 * @Version: 1.0
 */
public interface IAddressService {

    /**
     * 新增收货地址
     * @param uid
     * @param username
     * @param address
     * @return: void
     * @Author: liu
     * @Date: 2023/5/11 22:31
    */
    void addNewAddress(Integer uid, String username, Address address);


    List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param aid 收货地址的id
     * @param uid 用户id
     * @param username 修改执行人
     * @return: void
     * @Author: liu
     * @Date: 2023/5/23 20:47
    */
    void setDefault(Integer aid,Integer uid,String username);
}
