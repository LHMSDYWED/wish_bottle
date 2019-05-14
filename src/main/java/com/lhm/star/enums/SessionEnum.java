package com.lhm.star.enums;

/**
 * @author lhm
 * @date 2019/5/14 18:03
 **/
public enum SessionEnum {


    /**
     * CURRENT_USER: session中存储的当前用户
     */
    CURRENT_USER("CURRENT_USER"),;

    private String value;

    SessionEnum(String value) {
        this.value = value;
    }
}
