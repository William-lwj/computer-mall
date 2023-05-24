package com.xx.service;

import com.xx.pojo.Address;
import com.xx.pojo.District;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: IDistrictService
 * @Author: liu
 * @Date: 2023/5/20 23:27
 * @Version: 1.0
 */
public interface IDistrictService {
    /** 
     * 根据父代码号来查询区域信息(省或市或区)
     * @param parent 父代码号
     * @return 多个区域的信息
     * @Author: liu
     * @Date: 2023/5/20 23:29
    */
    List<District> getByParent(String parent);

    String getNameByCode(String code);


    
}
