package com.dm.springbootjpapostgresql;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootJpaPostgresqlApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootJpaPostgresqlApplication.class, args);

		Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
		
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
}
	}
        
