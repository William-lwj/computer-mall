package com.xx.controller;

import com.xx.controller.ex.*;
import com.xx.service.ex.*;
import com.xx.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


/**
 * @Description: 控制层下类的基类
 * @ClassName: BaseController
 * @Package: com.xx.controller
 * @Author: liu
 * @Date: 2023/5/8 14:56
 * @Version: 1.0
 */
public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler({ServiceException.class,FileUploadException.class}) //表示该方法用于处理捕获抛出的异常
    public JsonResult<Void> handleException(Throwable e) {

        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof UsernameNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名密码错误的异常");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户的收货地址超出上限的异常");
        }else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户的收货地址数据不存在的异常");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("收货地址数据非法访问的异常");
        }else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }


        return result;
    }

    /**
     * 获取session对象中的uid
     *
     * @param session session对象
     * @return: 当前登录的用户uid的值
     * @Author: liu
     * @Date: 2023/5/9 21:02
     */
    protected final Integer getUidFromSession(HttpSession session) {

        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession(HttpSession session) {

        return session.getAttribute("username").toString();
    }

}
