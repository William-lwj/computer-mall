package com.xx.controller;


import com.xx.pojo.Address;
import com.xx.service.IAddressService;
import com.xx.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: TODO
 * @ClassName: AddressController
 * @Package: com.xx.controller
 * @Author: liu
 * @Date: 2023/5/11 22:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK);

    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> list = addressService.getByUid(uid);
        return new JsonResult<>(OK, list);
    }

    @RequestMapping("set_default/{aid}")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session) {
        addressService.setDefault(aid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }


}
