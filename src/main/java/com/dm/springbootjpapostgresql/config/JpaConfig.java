package com.dm.springbootjpapostgresql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.OffsetDateTime;
import java.util.Optional;

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
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class JpaConfig {

@Bean
    public DateTimeProvider dateTimeProvider() {
        // This ensures the auditor provides OffsetDateTime instead of LocalDateTime
        return () -> Optional.of(OffsetDateTime.now());
    }
}