

package com.zjg.test.util.exception;

public class UnknownException extends CommonBizException {
    public UnknownException(String errorMessage) {
        super(CommonErrorCode.SYSTEM_ERROR, errorMessage, new Object[0]);
    }

    public UnknownException(String errorMessage, Throwable cause) {
        super(cause, CommonErrorCode.SYSTEM_ERROR, errorMessage, new Object[0]);
    }

    public UnknownException(String errorMessage, Throwable cause, boolean writableStackTrace) {
        super(writableStackTrace, cause, CommonErrorCode.SYSTEM_ERROR, errorMessage, new Object[0]);
    }
}
