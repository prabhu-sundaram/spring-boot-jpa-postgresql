package com.dm.springbootjpapostgresql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@Data
@ConfigurationProperties(prefix = "redis")
@EnableRedisRepositories(
    basePackages = "com.dm.springbootjpapostgresql.repository.redis"
)

public class RedisConfiguration {

    private String host;
    private Integer port;

    @Bean
    JedisPooled jedisPooled() {
        return new JedisPooled(host,port);
    }
}
