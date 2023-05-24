package com.xx.service.ex;

/**
 * @Description: 用户名被占用的异常
 * @ClassName: UsernameDuplicatedException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/7 22:48
 * @Version: 1.0
 */
public class UsernameDuplicatedException extends ServiceException {

    public UsernameDuplicatedException() {
        super();
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
