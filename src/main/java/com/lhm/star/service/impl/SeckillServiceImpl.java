package com.lhm.star.service.impl;

import com.lhm.star.mapper.SeckillMapper;
import com.lhm.star.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/**
 * @author lhm
 * @date 2019/5/7 11:23
 **/
@Service
@Transactional
public class SeckillServiceImpl implements SeckillService {

    private static final Long RELEASE_SUCCESS = 1L;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    @Autowired
    private SeckillMapper seckillMapper;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;//类型可以根据实际情况走

    /**
     * 获取分布式锁
     * @param jedis
     * @param lockKey
     * @param requireId
     * @param expireTime
     * @return
     */
   public  static boolean tryGetDistributedLock(Jedis jedis,String lockKey,String requireId,int expireTime){
       //jedis.set(String key, String value, String nxxx, String expx, int time)
       //key:使用它来当锁 value：传的是requestId ，通过知道value 便知道这个锁是哪个请求加的，requestId用可以使用UUID.randomUUID().toString()方法生成
       //nxxx：SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；
       //expx: 这个参数我们传的是PX，意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定
       //第五个为time，与第四个参数相呼应，代表key的过期时间
       requireId= UUID.randomUUID().toString();

       String result=jedis.set(lockKey,requireId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);

       if(LOCK_SUCCESS.equals(result)){
           return  true;
       }
       return false;
   }

    /**
     * 释放分布式锁
     * @param jedis
     * @param lockKey
     * @param requireId
     * @return
     */
   public  static boolean releaseDistributedLock(Jedis jedis,String lockKey,String requireId){
       //lua脚本代码
       String script="if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
       //先获取锁对应的value值 ，是否与requestId相等，相等则删除锁（解锁）   eval命令执行lua代码会被当成一个命令去执行，知道eval执行完成，redis才会执行其他命令
       Object result=jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requireId));
       if(RELEASE_SUCCESS.equals(result)){
           return true;
       }
       return  false;
   }

    @Override
    public int reduceStock(String seckillId, Date killTime) {
        //秒杀商品  库存减少1
       return seckillMapper.reduceStock(seckillId,killTime);

    }
}
