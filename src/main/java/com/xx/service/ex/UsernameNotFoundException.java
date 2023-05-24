package com.xx.service.ex;

/**
 * @Description: 用户名没有被找到的异常
 * @ClassName: UsernameNotFoundException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/9 10:59
 * @Version: 1.0
 */
public class UsernameNotFoundException extends ServiceException{

    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
