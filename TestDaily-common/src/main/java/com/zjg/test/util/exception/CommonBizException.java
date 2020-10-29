

package com.zjg.test.util.exception;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class CommonBizException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorCodeStr;
    private String errorMsg;
    private Object response;

    public CommonBizException(ErrorCode errorCode) {
        this((Throwable)null, errorCode);
    }

    public CommonBizException(Throwable throwable, ErrorCode resultCode) {
        this((Throwable)throwable, resultCode, (String)null);
    }

    public CommonBizException(ErrorCode errorCode, String errorMsg, Object... params) {
        this((Throwable)null, errorCode, errorMsg, params);
    }

    public CommonBizException(String errorCodeStr, String errorMsg, Object... params) {
        this(false, (Throwable)null, (String)errorCodeStr, errorMsg, params);
    }

    public CommonBizException(Object response, ErrorCode errorCode, String errorMsg, Object... params) {
        this((Throwable)null, response, errorCode, errorMsg, params);
    }

    public CommonBizException(Throwable throwable, ErrorCode errorCode, String errorMsg, Object... params) {
        this(throwable, (Object)null, errorCode, errorMsg, params);
    }

    public CommonBizException(Throwable throwable, Object response, ErrorCode errorCode, String errorMsg, Object... params) {
        this(true, throwable, errorCode, errorMsg, params);
        this.response = response;
    }

    public CommonBizException(boolean writableStackTrace, Throwable cause, ErrorCode errorCode, String errorMsg, Object... params) {
        super((String)null, cause, true, writableStackTrace);
        this.errorCode = errorCode;
        this.errorMsg = format(errorMsg, params);
    }

    public CommonBizException(boolean writableStackTrace, Throwable cause, String errorCodeStr, String errorMsg, Object... params) {
        super((String)null, cause, true, writableStackTrace);
        this.errorCodeStr = errorCodeStr;
        this.errorMsg = format(errorMsg, params);
    }

    private static String format(String message, Object... params) {
        return params != null && params.length != 0 ? formatMessage(message, params) : message;
    }

    private static String formatMessage(String message, Object[] params) {
        return message != null && params != null && params.length != 0 ? MessageFormat.format(message, params) : message;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        if (StringUtils.isNotBlank(this.errorMsg)) {
            return this.errorMsg;
        } else {
            return this.errorCode != null ? this.errorCode.getMsg() : "-";
        }
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getResponse() {
        return this.response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getErrorCodeStr() {
        if (StringUtils.isNotBlank(this.errorCodeStr)) {
            return this.errorCodeStr;
        } else {
            return this.errorCode != null ? this.errorCode.getCode() : null;
        }
    }

    public void setErrorCodeStr(String errorCodeStr) {
        this.errorCodeStr = errorCodeStr;
    }

    public String getMessage() {
        return this.getErrorCodeStr() + "," + this.getErrorMsg();
    }
}
