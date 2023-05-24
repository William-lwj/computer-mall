package com.xx.mapper;

import com.xx.pojo.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: AddressMapperTests
 * @Package: com.xx.mapper
 * @Author: liu
 * @Date: 2023/5/11 22:22
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {

    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> list = districtMapper.findByParent("210100");
        for (District district : list){
            System.out.println(district);
        }
    }
    @Test
    public void findNameByCode() {
        String name = districtMapper.findNameByCode("110100");
        System.out.println(name);
    }


}
