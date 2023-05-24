package com.xx.mapper;

import com.xx.pojo.District;

import java.util.List;

/**
 * @Description: TODO
 * @ClassName: DistrictMapper
 * @Author: liu
 * @Date: 2023/5/20 23:13
 * @Version: 1.0
 */
public interface DistrictMapper {

    /** 
     * 根据父代码号查询区域信息
     * @param parent 父代码号
     * @return 某个父区域下所有的区域列表
     * @Author: liu
     * @Date: 2023/5/20 23:15
    */
    List<District> findByParent(String parent);

    String findNameByCode(String code);

}
