package com.xx.mapper;

import com.xx.pojo.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(19);
        address.setPhone("100086");
        address.setName("女朋友");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid() {
        Integer count = addressMapper.countByUid(19);
        System.out.println(count);
    }

    @Test
    public void findByUid () {
        List<Address> list = addressMapper.findByUid(13);
        list.forEach(System.out::println);
    }

    @Test
    public void findByAid(){
        System.out.println(addressMapper.findByAid(12));
    }

    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(13);
    }

    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(12, "管理员", new Date());
    }

    @Test
    public void deleteByAid() {
        addressMapper.deleteByAid(7);
    }

    @Test
    public void findLastModified() {
        System.out.println(addressMapper.findLastModified(19));
    }


}
