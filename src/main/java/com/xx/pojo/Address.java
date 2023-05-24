package com.xx.pojo;

import lombok.Data;

/**
 * @Description: 收货地址
 * @ClassName: Address
 * @Package: com.xx.pojo
 * @Author: liu
 * @Date: 2023/5/11 9:36
 * @Version: 1.0
 */
@Data
public class Address extends BaseEntity{
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private String provinceCode;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;
}
