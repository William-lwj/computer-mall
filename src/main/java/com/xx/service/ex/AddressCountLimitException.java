package com.xx.service.ex;

/**
 * @Description: 收货地址总数超出限制的异常(20条)
 * @ClassName: AddressCountLimitException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/11 22:28
 * @Version: 1.0
 */
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
