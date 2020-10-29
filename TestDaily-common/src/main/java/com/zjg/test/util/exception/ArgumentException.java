
package com.zjg.test.util.exception;

public class ArgumentException extends CommonBizException {
    public ArgumentException(String errorMessage) {
        super(CommonErrorCode.ILLEGAL_PARAMETERS, errorMessage, new Object[0]);
    }

    public ArgumentException(String errorMessage, Throwable cause) {
        super(cause, CommonErrorCode.ILLEGAL_PARAMETERS, errorMessage, new Object[0]);
    }

    public ArgumentException(String errorMessage, Throwable cause, boolean writableStackTrace) {
        super(writableStackTrace, cause, CommonErrorCode.ILLEGAL_PARAMETERS, errorMessage, new Object[0]);
    }
}
