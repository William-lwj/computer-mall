package com.xx.controller.ex;

/**
 * @Description: 文件为空的异常(没有选择上传的文件就提交了表单,或选择的文件是0字节的空文件)
 * @ClassName: FileEmptyException
 * @Package: com.xx.controller.ex
 * @Author: liu
 * @Date: 2023/5/10 21:09
 * @Version: 1.0
 */
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
