package com.xx.pojo;

import lombok.Data;
import java.io.Serializable;

/**
 * @Description: 省市区的数据实体类
 * @ClassName: District
 * @Author: liu
 * @Date: 2023/5/20 23:04
 * @Version: 1.0
 */
@Data
public class District implements Serializable {

    private Integer id;
    private String parent;
    private String code;
    private String name;

}
