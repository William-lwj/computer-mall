package com.xx.service.ex;

/**
 * @Description: 业务层异常的基类
 * @ClassName: ServiceException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/7 22:44
 * @Version: 1.0
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
