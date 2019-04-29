package com.lhm.star.entity.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "会员表")
public class Member implements Serializable {
    private Integer id;

    private String member_uuid;

    private String member_name;

    private String member_nickname;

    private String login_name;

    private String login_password;

    private String register_phone;

    private Date create_time;

    private Date update_time;

    private static final long serialVersionUID = 1L;


}