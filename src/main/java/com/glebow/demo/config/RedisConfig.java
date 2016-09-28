/**
 * 
 */
package com.glebow.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author pglebow
 *
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig {

    /**
     * Redis connection factory
     * 
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory retVal = new JedisConnectionFactory();

        retVal.setUsePool(true);

        return retVal;
    }

    /**
     * Template
     * @return
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate() {

        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}
