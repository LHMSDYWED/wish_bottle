package com.lhm.star.service.impl;

import com.lhm.star.mapper.SeckillMapper;
import com.lhm.star.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lhm
 * @date 2019/5/7 11:23
 **/
@Service
@Transactional
public class SeckillServiceImpl implements SeckillService {

    private static final Long RELEASE_SUCCESS = 1L;
    @Autowired
    private SeckillMapper seckillMapper;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;//类型可以根据实际情况走

   
    @Override
    public int reduceStock(String seckillId, Date killTime) {
        //秒杀商品  库存减少1
       return seckillMapper.reduceStock(seckillId,killTime);

    }
}
