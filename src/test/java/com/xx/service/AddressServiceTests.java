package com.xx.service;

import com.xx.pojo.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @ClassName: AddressServiceTests
 * @Package: com.xx.service
 * @Author: liu
 * @Date: 2023/5/11 22:48
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress() {

        Address address = new Address();
        address.setPhone("10002");
        address.setName("男朋友");
        addressService.addNewAddress(19, "管理员", address);

    }

    @Test
    public void setDefault() {
        addressService.setDefault(3, 13, "管理员");
    }
}

