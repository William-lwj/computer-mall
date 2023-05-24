package com.xx.controller.ex;

/**
 * @Description: 文件大小超出限制
 * @ClassName: FileSizeException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:10
 * @Version: 1.0
 */
public class FileSizeException extends FileUploadException{
    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
