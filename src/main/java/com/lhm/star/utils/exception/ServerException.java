package com.lhm.star.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 服务端异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerException extends RuntimeException{
    private Integer code=500;
    private String msg="服务端异常";
}
