/**
 * 
 */
package com.glebow.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pglebow
 *
 */
@Configuration
@EnableRedisRepositories
@Slf4j
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;
    
    /**
     * Redis connection factory
     * 
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory retVal = new JedisConnectionFactory();
        retVal.setUsePool(true);        
        
        if ( redisHost != null && !redisHost.isEmpty()) {
            log.info("Connecting to the redis host " + redisHost);
            retVal.setHostName(redisHost);
        }
        
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
