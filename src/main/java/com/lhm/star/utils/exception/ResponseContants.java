package com.lhm.star.utils.exception;

/**
 * ResponseContants
 * 返回统一常量处理
 *
 * @author liufeihua
 * @date 2017/12/5 14:56
 */
public class ResponseContants {

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 成功消息
     */
    public static final String SUCCESS_MSG = "接口调用成功";

    /**
     * 请求参数错误
     */
    public static final int PARAMS_ERROR = 101;

    /**
     * 请求参数错误message
     */
    public static final String PARAMS_ERROR_MSG = "请求参数错误";
    /**
     * 用户不存在
     */
    public static final int NOUSERS = 201;
    /**
     * 密码错误
     */
    public static final int ERROR_PASSWORD = 202;
    /**
     * 上传文件失败
     */
    public static final int UPLOAD_FIEL_FAIL = 301;
    /**
     * 上传文件已存在
     */
    public static final int UPLOAD_FIEL_EXIST = 302;
    /**
     * 上传文件不能为空
     */
    public static final int UPLOAD_FIEL_NULL = 303;

    /**
     * ADD操作失败
     */
    public static final int ADD = 1000;
    /**
     * EDIT操作失败
     */
    public static final int EDIT = 1001;
    /**
     * DELETE操作失败
     */
    public static final int DELETE = 1002;
    /**
     * QUERY_EMPTY操作失败
     */
    public static final int QUERY_EMPTY = 1003;
    /**
     * QUERY_EMPTY操作失败
     */
    public static final int QUERY_RESULT_EMPTY = 1004;

    /**
     * 操作失败message
     */
    public static final String ADD_MESSAGE = "添加失败";
    /**
     * 操作失败message
     */
    public static final String EDIT_MESSAGE = "修改失败";
    /**
     * 操作失败message
     */
    public static final String DELETE_MESSAGE = "删除失败";
    /**
     * 操作失败message
     */
    public static final String QUERY_EMPTY_MESSAGE = "查询失败";
    /**
     * 操作失败message
     */
    public static final String QUERY_RESULT_EMPTY_MESSAGE = "查询结果为空";
    /**
     * 上传文件不能为空message
     */
    public static final String UPLOAD_FIEL_NULL_MESSAGE = "查询失败";

}
