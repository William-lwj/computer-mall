package com.xx.service.ex;

/**
 * @Description: 数据插入过程中产生异常
 * @ClassName: InsertException
 * @Package: com.xx.service.ex
 * @Author: liu
 * @Date: 2023/5/7 22:50
 * @Version: 1.0
 */
public class InsertException extends ServiceException {
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
