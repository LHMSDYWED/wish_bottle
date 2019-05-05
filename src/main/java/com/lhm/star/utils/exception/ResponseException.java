package com.lhm.star.utils.exception;

/**
 * ResponseException
 * 返回异常统一处理
 *
 * @author liufeihua
 * @date 2017/12/5 14:52
 */
public class ResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code = 200;

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ResponseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ResponseException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.code = responseMessage.getCode();
    }

    public static ResponseException create(int code, String message) {
        return new ResponseException(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
