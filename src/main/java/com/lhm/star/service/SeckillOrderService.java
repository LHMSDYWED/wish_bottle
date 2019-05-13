package com.lhm.star.service;

import com.lhm.star.entity.model.SeckillOrder;

/**
 * @author lhm
 * @date 2019/5/7 11:23
 **/
public interface SeckillOrderService {


    /**
     * 插入一条订单明细
     * @param record
     * @return
     */
    int insertSelective(SeckillOrder record);
}
