package com.dm.springbootjpapostgresql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

@Configuration
@EnableLdapRepositories(
    basePackages = "com.dm.springbootjpapostgresql.repository.ldap"
)
public class LdapConfig {
}
