package com.lhm.star.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

@Configuration
@EnableCaching//开启注解
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 自定义key  此方法会根据类名+方法名+所以参数的值 生成唯一的一个key
     * 及时@cacheable中的value属性一样，key也会不一样
     */
    /**
     * 连接
     *
     * @param config
     * @param host
     * @param port
     * @return
     */
    @Bean(name = "jedis.pool")
    @Autowired
    public JedisPool jedisPool(@Qualifier("redis.pool.config") JedisPoolConfig config,
                               @Value("${spring.redis.host}") String host,
                               @Value("${spring.redis.timeout}") int timeout,
                               @Value("${spring.redis.port}") int port) {
        JedisPool jedisPool = new JedisPool(config, host, port, timeout);
        return jedisPool;
    }

    /**
     * 配置jedis数据库连接池
     *
     * @param maxIdle   最大空闲连接
     * @param maxActive 最大连接数
     * @param maxWait   最大等待时间
     * @param minIdle   最小连接数
     * @return
     */
    @Bean(name = "redis.pool.config")
    public JedisPoolConfig jedisPoolConfig(@Value("${spring.redis.pool.maxIdle}") int maxIdle,
                                           @Value("${spring.redis.pool.max-active}") int maxActive,
                                           @Value("${spring.redis.pool.max-wait}") int maxWait,
                                           @Value("${spring.redis.pool.min-idle}") int minIdle) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setMinIdle(minIdle);
        return config;
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //  使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用jdk的序列化方式）
        Jackson2JsonRedisSerializer serializer=new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper=new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer 来序列化和反序列化redis的key值
        template.setValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }



}  