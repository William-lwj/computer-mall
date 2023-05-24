package com.xx.service.ex;

/**
 * @Description: 用户在更新数据时产生的未知异常
 * @ClassName: UpdateException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/9 22:09
 * @Version: 1.0
 */
public class UpdateException extends ServiceException{
    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
