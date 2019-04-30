package com.lhm.star.service;

import com.lhm.star.entity.model.ESEntity;


import java.util.List;

public interface CityESService {

    void saveEntity(ESEntity entity);

    void saveEntity(List<ESEntity> entityList);

    List<ESEntity> searchEntity(String searchContent);

}
