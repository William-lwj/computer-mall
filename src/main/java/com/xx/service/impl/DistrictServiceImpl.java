package com.xx.service.impl;

import com.xx.mapper.DistrictMapper;
import com.xx.pojo.District;
import com.xx.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: DistrictServiceImpl
 * @Author: liu
 * @Date: 2023/5/20 23:30
 * @Version: 1.0
 */
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for (District district: list) {
            district.setId(null);
            district.setParent(null);
        }
        return list;

    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }


}
