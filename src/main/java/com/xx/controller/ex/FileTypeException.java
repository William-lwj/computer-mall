package com.xx.controller.ex;

/**
 * @Description: 文件类型异常(上传的文件类型超出了限制)
 * @ClassName: FileTypeException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:10
 * @Version: 1.0
 */
public class FileTypeException extends FileUploadException{
    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
