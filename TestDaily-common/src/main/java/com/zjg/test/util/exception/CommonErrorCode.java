

package com.zjg.test.util.exception;

public enum CommonErrorCode implements ErrorCode {
    SUCCESS("处理成功"),
    SYSTEM_ERROR("系统错误，请稍后重试"),
    ILLEGAL_PARAMETERS("非法请求参数"),
    INVALID_PARAMETER("无效请求参数"),
    DATA_OPERATION_NOT_ALLOWED("数据不允许操作"),
    NULL_PARAMETER("非空参数"),
    SERVICE_INVOKE_ERROR("服务调用失败"),
    DATA_NOT_EXIST("数据不存在"),
    DATA_IS_EXIST("数据已存在"),
    DB_OPERATE_FAIL("数据库操作失败"),
    DATA_COPY_ERROR("数据copy错误"),
    OPERATOR_NO_PERMISSION("操作员无权限"),
    UNAUTHORIZED("未授权");

    private String msg;

    private CommonErrorCode(String msg) {
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
