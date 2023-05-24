package com.xx.service.ex;

/**
 * @Description: TODO
 * @ClassName: DeleteException
 * @Author: liu
 * @Date: 2023/5/23 23:25
 * @Version: 1.0
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
