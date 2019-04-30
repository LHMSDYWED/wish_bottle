package com.lhm.star.entity.model;

import java.io.Serializable;

/**
 * @program: springboot_es
 * @description: es实体类
 * @author: DP_Li
 * @create: 2019/02/24
 */

public class ESEntity implements Serializable {

    public static final String INDEX_NAME = "index_entity";

    public static final String TYPE = "tstype";

    private static final long serialVersionUID = -8032614488548672102L;

    private Long id;

    private String name;

    public ESEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getIndexName() {
        return INDEX_NAME;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ESEntity() {
        super();
    }
}
