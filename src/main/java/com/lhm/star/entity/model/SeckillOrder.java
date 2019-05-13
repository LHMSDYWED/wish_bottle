package com.lhm.star.entity.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SeckillOrder implements Serializable {
    private Integer id;

    private String seckillId;

    private Integer money;

    private String userPhone;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;


}