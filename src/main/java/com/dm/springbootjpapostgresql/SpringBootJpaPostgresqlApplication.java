package com.dm.springbootjpapostgresql;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.dm.springbootjpapostgresql.profiles.ProfileManager;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootJpaPostgresqlApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Autowired
    private Environment environment;

	@Bean
    public Environment getEnvironment() {
        return environment;
    }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		
		//SpringApplication.run(SpringBootJpaPostgresqlApplication.class, args);

		SpringApplication application = new SpringApplication(SpringBootJpaPostgresqlApplication.class);
		application.run();

		// // Get the Environment before running the application
		// Environment environment = application.getEnvironment();

		// // Now you can use the environment safely
		// ProfileManager profileManager = new ProfileManager(environment);
		// profileManager.getActiveProfiles();		

		Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
		
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");


}
	}
        
