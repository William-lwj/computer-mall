package com.xx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 实体的类的基类
 * @ClassName: BaseEntity
 * @Package: com.xx.pojo.entity
 * @Author: liu
 * @Date: 2023/5/7 17:15
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;


}
