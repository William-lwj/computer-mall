package com.xx.service;

import com.xx.pojo.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: DistrictServiceTests
 * @Author: liu
 * @Date: 2023/5/20 23:34
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests{
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        //86代表中国,所有的省父代码号都是86
        List<District> list = districtService.getByParent("86");
        for (District district : list) {
            System.err.println(district);
        }
    }
}
