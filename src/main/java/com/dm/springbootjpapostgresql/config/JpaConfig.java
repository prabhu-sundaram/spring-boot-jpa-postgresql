package com.dm.springbootjpapostgresql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EnableJpaRepositories(
    basePackages = {"com.dm.springbootjpapostgresql.repository.jpa"
    }
)
@EntityScan(
    basePackages = {"com.dm.springbootjpapostgresql.model.entity"
    }
)
public class JpaConfig {
}