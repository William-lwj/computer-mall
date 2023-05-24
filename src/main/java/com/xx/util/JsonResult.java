package com.xx.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: Json格式进行响应
 * 状态码,状态描述信息,数据是所有控制层对应的方法都涉及到的操作,
 * 所以把这部分功能封装到一个类JsonResult中,
 * 将这个类作为方法的返回值返回给前端浏览器:
 * @ClassName: JsonResult
 * @Package: com.xx.util
 * @Author: liu
 * @Date: 2023/5/8 14:25
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述信息
    private String message;

    private E data;


    //如果有异常,直接将异常传递给构造方法初始化对象
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
}
