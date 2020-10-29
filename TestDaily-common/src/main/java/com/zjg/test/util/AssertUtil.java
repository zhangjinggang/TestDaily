package com.zjg.test.util;

import com.zjg.test.util.exception.CommonBizException;
import com.zjg.test.util.exception.CommonErrorCode;
import com.zjg.test.util.exception.ErrorCode;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * 参数检查断言工具类，可以减少一些<code>if</code>代码逻辑<br> 当断言不成立时，抛出指定错误代码的Exception异常
 *
 * @author mingxing.xmx
 */
public final class AssertUtil {

    /**
     * 禁用构造函数
     */
    private AssertUtil() {
        // 禁用构造函数
    }

    /**
     * 期待对象为非空，如果检查的对象为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object obj
     * @throws CommonBizException e
     */
    public static void isNotNull(Object object) {
        isNotNull(object, CommonErrorCode.ILLEGAL_PARAMETERS);
    }

    /**
     * 期待对象为非空，如果检查的对象为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object    obj
     * @param errorCode errorCode
     * @throws CommonBizException e
     */
    public static void isNotNull(Object object, ErrorCode errorCode) {
        if (object == null) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待对象为非空，如果检查的对象为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object    obj
     * @param errorCode errorCode
     * @param message   异常说明
     * @throws CommonBizException e
     */
    public static void isNotNull(Object object, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (object == null) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待对象为非空，如果检查的对象为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object  obj
     * @param message 异常说明
     * @throws CommonBizException e
     */
    public static void isNotNull(Object object, String message)
        throws CommonBizException {
        isNotNull(object, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待字符串为非空，如果检查字符串是空白：<code>null</code>、空字符串""或只有空白字符，抛出异常<code>CommonBizException</code>
     *
     * @param text      待检查的字符串
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isNotBlank(String text, ErrorCode errorCode) throws CommonBizException {
        if (StringUtils.isBlank(text)) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待字符串为非空，如果检查字符串是空白：<code>null</code>、空字符串""或只有空白字符，
     *
     * <code>WaiMaiException</code>
     *
     * @param text      待检查的字符串
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isNotBlank(String text, ErrorCode errorCode, String errorMsg)
        throws CommonBizException {
        if (StringUtils.isBlank(text)) {
            throw new CommonBizException(errorCode, errorMsg);
        }
    }

    /**
     * 期待字符串为非空，如果检查字符串是空白：<code>null</code>、空字符串""或只有空白字符，
     *
     * <code>WaiMaiException</code>
     *
     * @param text     待检查的字符串
     * @param errorMsg 错误描述
     * @throws CommonBizException e
     */
    public static void isNotBlank(String text, String errorMsg)
        throws CommonBizException {
        isNotBlank(text, CommonErrorCode.ILLEGAL_PARAMETERS, errorMsg);
    }

    /**
     * 期待字符串为空，如果检查字符串是非空白：<code>null</code>、非空字符串""非空则，抛出异常<code>CommonBizException</code>
     *
     * @param text      待检查的字符串
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isBlank(String text, ErrorCode errorCode) throws CommonBizException {
        if (StringUtils.isNotBlank(text)) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待字符串为空，如果检查字符串是非空白：<code>null</code>、非空字符串""或只有空白字符，非空则，抛出异常.
     *
     * <code>WaiMaiException</code>
     *
     * @param text      待检查的字符串
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isBlank(String text, ErrorCode errorCode, String errorMsg)
        throws CommonBizException {
        if (StringUtils.isNotBlank(text)) {
            throw new CommonBizException(errorCode, errorMsg);
        }
    }

    /**
     * 期待字符串为空，如果检查字符串是非空白：<code>null</code>、非空字符串""或只有空白字符，非空则，抛出异常.
     *
     * <code>WaiMaiException</code>
     *
     * @param text     待检查的字符串
     * @param errorMsg 错误描述
     * @throws CommonBizException e
     */
    public static void isBlank(String text, String errorMsg)
        throws CommonBizException {
        isBlank(text, CommonErrorCode.ILLEGAL_PARAMETERS, errorMsg);
    }

    /**
     * 期待数字为0以上，如果坚持数字是0或者小于0，抛出异常<code>CommonBizException</code>
     *
     * @param num       待坚持数字
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isNotEqualOrLessThanZero(long num, ErrorCode errorCode)
        throws CommonBizException {
        if (0 == num || 0 > num) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期望num>=compare,否则抛异常
     *
     * @param num       num
     * @param compare   对比
     * @param errorCode errorCode
     * @throws CommonBizException e
     */
    public static void isNotLess(long num, long compare, ErrorCode errorCode)
        throws CommonBizException {
        if (num < compare) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期望num>=compare,否则抛异常
     *
     * @param num       num
     * @param compare   对比
     * @param errorCode errorCode
     * @throws CommonBizException
     */
    public static void isNotLess(long num, long compare, ErrorCode errorCode, String errorMsg)
        throws CommonBizException {
        if (num < compare) {
            throw new CommonBizException(errorCode, errorMsg);
        }
    }

    /**
     * 期待集合对象为非空，如果检查集合对象是否为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isNotEmpty(Collection<?> collection, ErrorCode errorCode)
        throws CommonBizException {
        if (collection == null || collection.isEmpty()) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待集合对象为非空，如果检查集合对象是否为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isNotEmpty(Collection<?> collection, ErrorCode errorCode, String errorMsg)
        throws CommonBizException {
        if (collection == null || collection.isEmpty()) {
            throw new CommonBizException(errorCode, errorMsg);
        }
    }

    /**
     * 期待集合对象为非空，如果检查集合对象是否为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorMsg   异常代码
     * @throws CommonBizException e
     */
    public static void isNotEmpty(Collection<?> collection, String errorMsg)
        throws CommonBizException {
        isNotEmpty(collection, CommonErrorCode.ILLEGAL_PARAMETERS, errorMsg);
    }

    /**
     * 期待集合对象为空，如果检查集合对象不为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isEmpty(Collection<?> collection, ErrorCode errorCode)
        throws CommonBizException {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        throw new CommonBizException(errorCode);
    }

    /**
     * 期待集合对象为空，如果检查集合对象不为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isEmpty(Collection<?> collection, ErrorCode errorCode, String errorMsg)
        throws CommonBizException {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        throw new CommonBizException(errorCode, errorMsg);
    }

    /**
     * 期待集合对象为空，如果检查集合对象不为null或者空数据，抛出异常<code>CommonBizException</code>
     *
     * @param collection 集合对象
     * @param errorMsg   异常代码
     * @throws CommonBizException e
     */
    public static void isEmpty(Collection<?> collection, String errorMsg)
        throws CommonBizException {
        isEmpty(collection, CommonErrorCode.ILLEGAL_PARAMETERS, errorMsg);
    }

    /**
     * 期待数组对象为非空
     *
     * @param array     数组
     * @param errorCode errorCode
     * @throws CommonBizException e
     */
    public static void isNotEmpty(Object[] array, ErrorCode errorCode, String errorMsg) throws CommonBizException {
        if (ArrayUtils.isEmpty(array)) {
            throw new CommonBizException(errorCode, errorMsg);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isTrue(boolean expression, ErrorCode errorCode)
        throws CommonBizException {
        if (!expression) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect    期望值
     * @param real      实际值
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isEqual(String expect, String real, ErrorCode errorCode)
        throws CommonBizException {
        if (!StringUtils.equals(expect, real)) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect    期望值
     * @param real      实际值
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isEqual(String expect, String real, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (!StringUtils.equals(expect, real)) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect  期望值
     * @param real    实际值
     * @param message 异常代码
     * @throws CommonBizException e
     */
    public static void isEqual(String expect, String real, String message)
        throws CommonBizException {
        isEqual(expect, real, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect    期望值
     * @param real      实际值
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isNotEqual(String expect, String real, ErrorCode errorCode)
        throws CommonBizException {
        if (StringUtils.equals(expect, real)) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect    期望值
     * @param real      实际值
     * @param errorCode 异常代码
     * @throws CommonBizException e
     */
    public static void isNotEqual(String expect, String real, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (StringUtils.equals(expect, real)) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expect  期望值
     * @param real    实际值
     * @param message 异常代码
     * @throws CommonBizException e
     */
    public static void isNotEqual(String expect, String real, String message)
        throws CommonBizException {
        isNotEqual(expect, real, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待的正确值为false，如果实际为true，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  异常代码
     * @throws CommonBizException e
     */
    public static void isFalse(boolean expression, ErrorCode errorCode)
        throws CommonBizException {
        if (expression) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  错误代码
     * @param message    异常说明
     * @throws CommonBizException e
     */
    public static void isTrue(boolean expression, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (!expression) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param message    异常说明
     * @throws CommonBizException e
     */
    public static void isTrue(boolean expression, String message)
        throws CommonBizException {
        isTrue(expression, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待的正确值为true，如果实际为false，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  错误代码
     * @param message    异常说明
     * @param params     参数
     * @throws CommonBizException e
     */
    public static void isTrue(boolean expression, ErrorCode errorCode, String message, Object... params)
        throws CommonBizException {
        if (!expression) {
            throw new CommonBizException(errorCode, message, params);
        }
    }

    /**
     * 期待的正确值为false，如果实际为true，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  错误代码
     * @param message    异常说明
     * @throws CommonBizException e
     */
    public static void isFalse(boolean expression, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (expression) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待的正确值为false，如果实际为true，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param message    异常说明
     * @throws CommonBizException e
     */
    public static void isFalse(boolean expression, String message)
        throws CommonBizException {
        isFalse(expression, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待的正确值为false，如果实际为true，抛出异常<code>CommonBizException</code>
     *
     * @param expression 表达式
     * @param errorCode  错误代码
     * @param message    异常说明
     * @throws CommonBizException e
     */
    public static void isFalse(boolean expression, ErrorCode errorCode, String message, Object... params)
        throws CommonBizException {
        if (expression) {
            throw new CommonBizException(errorCode, message, params);
        }
    }

    /**
     * 期待对象为空，如果检查的对象不为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object    对象
     * @param errorCode 错误代码
     * @throws CommonBizException e
     */
    public static void isNull(Object object, ErrorCode errorCode) throws CommonBizException {
        if (object != null) {
            throw new CommonBizException(errorCode);
        }
    }

    /**
     * 期待对象为空，如果检查的对象不为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object    对象
     * @param errorCode 错误代码
     * @throws CommonBizException e
     */
    public static void isNull(Object object, ErrorCode errorCode, String message)
        throws CommonBizException {
        if (object != null) {
            throw new CommonBizException(errorCode, message);
        }
    }

    /**
     * 期待对象为空，如果检查的对象不为<code>null</code>，抛出异常<code>CommonBizException</code>
     *
     * @param object  对象
     * @param message 错误代码
     * @throws CommonBizException e
     */
    public static void isNull(Object object, String message)
        throws CommonBizException {
        isNull(object, CommonErrorCode.ILLEGAL_PARAMETERS, message);
    }

    /**
     * 期待对象为false，如果检查的对象不为<code>true</code>，抛出异常<code>CommonBizException</code>
     *
     * @param success   对象
     * @param errorCode 错误代码
     * @param message   错误信息
     * @throws CommonBizException e
     */
    public static void isSuccess(boolean success, String errorCode, String message)
        throws CommonBizException {
        if (!success) {
            throw new CommonBizException(errorCode, message);
        }
    }

    public static void isZeroOrOne(int flag, String message)
        throws CommonBizException {
        if (flag != 0 || flag != 1) {
            throw new CommonBizException(CommonErrorCode.INVALID_PARAMETER, message);
        }
    }

}
