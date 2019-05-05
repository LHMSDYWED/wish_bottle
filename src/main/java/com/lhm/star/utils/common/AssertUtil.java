package com.lhm.star.utils.common;



import com.lhm.star.utils.exception.ResponseException;
import com.lhm.star.utils.exception.ResponseMessage;
import com.lhm.star.utils.exception.ServerException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


import java.util.Collection;
import java.util.Optional;

/**
 * 业务异常工具类,语法类似junit断言语法
 *
 * @author 刘飞华
 * @version v1.0
 * @date 2016年7月21日
 */
public class AssertUtil {
    private AssertUtil() {
    }

    /**
     * 断定目标值为false.为true则抛出业务异常
     *
     * @param expression
     * @param message
     * @throws ResponseException
     */
    public static void isFlase(boolean expression, String message) {
        if (expression) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标值为false.为true则抛出业务异常
     *
     * @param expression
     * @param message
     * @throws ResponseException
     */
    public static void isFlase(boolean expression, String message, int code) {
        if (expression) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标值为true.为false则抛出业务异常
     *
     * @param expression
     * @param message
     * @throws ResponseException
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标值为true.为false则抛出业务异常
     *
     * @param expression
     * @param message
     * @throws ResponseException
     */
    public static void isTrue(boolean expression, String message, int code) {
        if (!expression) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标值为null.不为null则抛出业务异常
     *
     * @param obj
     * @param message
     * @throws ResponseException
     */
    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标值为null.不为null则抛出业务异常
     *
     * @param obj
     * @param message
     * @throws ResponseException
     */
    public static void isNull(Object obj, String message, int code) {
        if (obj != null) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标值不为null.为null则抛出业务异常
     *
     * @param obj
     * @param message
     * @throws ResponseException
     */
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标值不为null.为null则抛出业务异常
     *
     * @param obj
     * @param message
     * @throws ResponseException
     */
    public static void notNull(Object obj, String message, int code) {
        if (obj == null) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标list不为空.为空则抛出业务异常
     *
     * @param collection
     * @param message
     * @throws ResponseException
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标list不为空.为空则抛出业务异常
     *
     * @param collection
     * @param message
     * @throws ResponseException
     */
    public static void notEmpty(Collection<?> collection, String message, int code) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标list为空.不为空则抛出业务异常
     *
     * @param collection
     * @param message
     * @throws ResponseException
     */
    public static void isEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标list为空.不为空则抛出业务异常
     *
     * @param collection
     * @param message
     * @throws ResponseException
     */
    public static void isEmpty(Collection<?> collection, String message, int code) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标字符串不为空.为空则抛出业务异常
     *
     * @param string
     * @param message
     * @throws ResponseException
     */
    public static void notEmpty(String string, String message) {

        if (StringUtils.isBlank(string)) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标字符串不为空.为空则抛出业务异常
     *
     * @param string
     * @param message
     * @throws ResponseException
     */
    public static void notEmpty(String string, String message, int code) {

        if (StringUtils.isBlank(string)) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定目标字符串为空.不为空则抛出业务异常
     *
     * @param string
     * @param message
     * @throws ResponseException
     */
    public static void empty(String string, String message) {

        if (StringUtils.isNotBlank(string)) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定目标字符串为空.不为空则抛出业务异常
     *
     * @param string
     * @param message
     * @throws ResponseException
     */
    public static void empty(String string, String message, int code) {

        if (StringUtils.isNotBlank(string)) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定两个字符串不相等,相等则抛出指定业务异常
     *
     * @param source
     * @param target
     * @param message
     * @throws ResponseException
     */
    public static void notEqualString(String source, String target, String message) {
        if (source.equals(target)) {
            throw new ResponseException(message);
        }
    }

    /**
     * 断定两个字符串不相等,相等则抛出指定业务异常
     *
     * @param source
     * @param target
     * @param message
     * @throws ResponseException
     */
    public static void notEqualString(String source, String target, String message, int code) {
        if (source.equals(target)) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定数值是否大于0,不大于则抛出指定业务异常
     *
     * @param number
     * @param message
     * @throws ResponseException
     * @author taok
     * @date 2016-04-11
     */
    public static void numberGtZero(Integer number, String message, int code) {
        if (number == null || number <= 0) {
            throw new ResponseException(code, message);
        }
    }

    /**
     * 断定数值是否大于0,不大于则抛出指定业务异常
     *
     * @param number
     * @param message
     * @throws ResponseException
     * @author taok
     * @date 2016-04-20
     */
    public static void longGtZero(Long number, String message, int code) {
        if (number == null || number <= 0) {
            throw new ResponseException(message, code);
        }
    }

    /**
     * 断定数值大于指定数值则抛出指定业务异常
     *
     * @param number
     * @param message
     * @throws ResponseException
     * @author taok
     * @date 2016-04-20
     */
    public static void longGtNumber(Long number, Long targetNumber, String message) {
        if (number != null && number > targetNumber) {
            throw new ResponseException(message);
        }
    }


    /**
     * 远程调用结果返回ResponseMessage判断
     * @param res
     */
    public static void isRemoteInvokeSuccess(ResponseMessage res){
        Optional.of(res).filter(responseMessage -> responseMessage.getCode()==200)
                .orElseThrow(()->new ServerException(500,"远程调用异常"));

    }

    /**
     * 远程调用是否返回正常数字
     * @param result
     */
    public static void isRemoteInvokeNum(int result){
        if(result!=1){
            throw  new ServerException(500,"远程调用异常");
        }
    }

    /**
     * 查询数据库数据为空
     * @param obj
     */
    public void isQueryEmpty(Object obj){
        if(obj==null){
            throw  new ServerException(1004,"查询数据为空");
        }
    }
}
