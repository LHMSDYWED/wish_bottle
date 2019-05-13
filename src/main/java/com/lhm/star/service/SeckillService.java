package com.lhm.star.service;

import java.util.Date;

/**
 * @author lhm
 * @date 2019/5/7 11:22
 **/
public interface SeckillService {

    /**
     * 根据id 秒杀时间减少库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceStock(String seckillId, Date killTime);
}
