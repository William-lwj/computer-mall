package com.xx.controller.ex;

/**
 * @Description: 文件状态异常(上穿文件时该文件正在打开状态)
 * @ClassName: FileStateException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:11
 * @Version: 1.0
 */
public class FileStateException extends FileUploadException{

    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
