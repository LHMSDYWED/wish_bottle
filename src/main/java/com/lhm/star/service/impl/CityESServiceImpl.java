package com.lhm.star.service.impl;


import com.lhm.star.entity.model.ESEntity;
import com.lhm.star.service.CityESService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @program: springboot_es
 * @description: 实现类
 * @author: DP_Li
 * @create: 2019/02/24
 */
@Service
public class CityESServiceImpl implements CityESService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    private JestClient jestClient;

    @Override
    public void saveEntity(ESEntity entity) {
        Index index = new Index.Builder(entity).index(ESEntity.INDEX_NAME).type(ESEntity.TYPE).build();
        try {
            jestClient.execute(index);
            LOGGER.info("ES 插入完成");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }


    /**
     * 批量保存内容到ES
     */
    @Override
    public void saveEntity(List<ESEntity> entityList) {
        Bulk.Builder bulk = new Bulk.Builder();
        for(ESEntity entity : entityList) {
            Index index = new Index.Builder(entity).index(ESEntity.INDEX_NAME).type(ESEntity.TYPE).build();
            bulk.addAction(index);
        }
        try {
            jestClient.execute(bulk.build());
            LOGGER.info("ES 插入完成");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * 在ES中搜索内容
     */
    @Override
    public List<ESEntity> searchEntity(String searchContent){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));
        //searchSourceBuilder.field("name");
        searchSourceBuilder.query(QueryBuilders.matchQuery("name",searchContent));
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(ESEntity.INDEX_NAME).addType(ESEntity.TYPE).build();
        try {
            JestResult result = jestClient.execute(search);
            return result.getSourceAsObjectList(ESEntity.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

