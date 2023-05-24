package com.xx.controller.ex;

/**
 * @Description: 文件异常类的基类
 * @ClassName: FileUploadException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:03
 * @Version: 1.0
 */
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
