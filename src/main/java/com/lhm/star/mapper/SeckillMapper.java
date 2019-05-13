package com.lhm.star.mapper;

import com.lhm.star.entity.model.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface SeckillMapper {


    /**
     * 根据id 秒杀时间减少库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceStock(String seckillId, Date killTime);

}