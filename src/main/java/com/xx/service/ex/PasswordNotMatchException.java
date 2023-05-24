package com.xx.service.ex;

/**
 * @Description: 密码匹配的异常
 * @ClassName: PasswordNotMatchException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/9 10:58
 * @Version: 1.0
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
