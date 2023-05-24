package com.xx.controller.ex;

/**
 * @Description: 文件读写异常
 * @ClassName: FileUploadIOException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:10
 * @Version: 1.0
 */
public class FileUploadIOException extends FileUploadException{
    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
