package com.lhm.star.mapper;

import com.lhm.star.entity.model.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillOrderMapper {


    /**
     * 插入一条订单明细
     * @param record
     * @return
     */
    int insertSelective(SeckillOrder record);


}