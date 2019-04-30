package com.lhm.star.controller;


import com.lhm.star.entity.model.ESEntity;
import com.lhm.star.service.CityESService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot_es
 * @description: es测试类
 * @author: DP_Li
 * @create: 2019/02/24
 */
@Api(tags = "ES搜索引擎")
@RestController
@RequestMapping("/esentityController")
public class ESEntityController {

    @Autowired
    private CityESService cityESService;

    /**
     * 批量保存内容到ES
     * @param id
     * @param name
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "批量保存内容到ES")
    @GetMapping(value="/save")
    public String save(long id, String name) {
        if(id>0 && StringUtils.isNotEmpty(name)) {
            ESEntity newEntity = new ESEntity(id,name);
            List<ESEntity> addList = new ArrayList<ESEntity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "提交数据有误";
        }
    }

    /**
     * 在ES中搜索内容
     * @param name
     * @return
     */
    @ApiOperation(httpMethod = "GET",value = "在ES中搜索内容")
    @GetMapping(value="/search")
    public List<ESEntity> save(String name) {
        List<ESEntity> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            entityList = cityESService.searchEntity(name);
        }
        return entityList;
    }

    //添加
    @ApiOperation(httpMethod = "GET",value = "添加")
    @GetMapping(value="/add")
    public void insert(long id, String name) {

    }


}
