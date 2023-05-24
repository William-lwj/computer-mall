package com.xx.controller;

import com.xx.pojo.District;
import com.xx.service.IDistrictService;
import com.xx.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: DistrictsController
 * @Author: liu
 * @Date: 2023/5/21 20:19
 * @Version: 1.0
 */
@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController {

    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK,data);
    }

}
