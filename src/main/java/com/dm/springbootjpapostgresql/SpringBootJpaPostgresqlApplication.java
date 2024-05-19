package com.dm.springbootjpapostgresql;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dm.springbootjpapostgresql.model.Post2;
import com.dm.springbootjpapostgresql.profiles.ProfileManager;
import com.dm.springbootjpapostgresql.repository.Post2Repository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.search.FieldName;
import redis.clients.jedis.search.IndexDefinition;
import redis.clients.jedis.search.IndexOptions;
import redis.clients.jedis.search.Schema;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.dm.springbootjpapostgresql.service.HttpClient.*;
import com.dm.springbootjpapostgresql.config.DatabaseProperties;
//import com.dm.springbootjpapostgresql.example.dbPkg.*;
import com.dm.springbootjpapostgresql.service.FileOps.*;

@SpringBootApplication
// @ComponentScan(basePackages = {
//     "com.dm.springbootjpapostgresql.config",
//     "com.dm.springbootjpapostgresql.model",
//     "com.dm.springbootjpapostgresql.collection",       
//     "com.dm.springbootjpapostgresql.repository",
//     "com.dm.springbootjpapostgresql.repository2",    
//     "com.dm.springbootjpapostgresql.service",
//     "com.dm.springbootjpapostgresql.controller",
//     "com.dm.springbootjpapostgresql.interceptor",
//     "com.dm.springbootjpapostgresql.mapper"
// },
// excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Post2Repository.class})
// )
// @EnableJpaRepositories(
//     value = "com.dm.springbootjpapostgresql",
//     repositoryBaseClass = BaseJpaRepositoryImpl.class
// )
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

    @Autowired
    private DatabaseProperties databaseProperties;

    //@Autowired
    //JDBCExample2 example2;

    // @Autowired
    // private Post2Repository postRepository;

    // @Autowired
    // private UnifiedJedis jedis;

	// @Autowired
	// HttpClientService       httpClientService;
    // @Autowired
    // ApacheHttpClientService     apacheHttpClientService;
    // @Autowired
    // OkHttpClientService     okHttpClientService;
    // @Autowired
    // WebClientService    webClientService;

    @Autowired
    FileWriteService    fileWriteService;


    // @Value("classpath:data.json")
    // Resource resourceFile;

    // @Bean
    // CommandLineRunner loadData() {
    //     return args -> {
    //         postRepository.deleteAll();

    //         try {
    //             jedis.ftDropIndex("post-idx");
    //         } catch (Exception e) {
    //             System.out.println("Index is not available");
    //         }

    //         String data = new String(resourceFile
    //                 .getInputStream()
    //                 .readAllBytes());

    //         ObjectMapper objectMapper
    //                 = new ObjectMapper()
    //                 .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    //         Post2[] posts =
    //                 objectMapper.readValue(data, Post2[].class);
    //         Arrays.stream(posts).forEach(postRepository::save);

    //         Schema schema = new Schema()
    //                 .addField(new Schema.Field(FieldName.of("$.content").as("content"), Schema.FieldType.TEXT,true,false))
    //                 .addField(new Schema.TextField(FieldName.of("$.title").as("title")))
    //                 .addField(new Schema.Field(FieldName.of("$.tags[*]").as("tags"), Schema.FieldType.TAG))
    //                 .addField(new Schema.Field(FieldName.of("$.views").as("views"), Schema.FieldType.NUMERIC,false,true));

    //         IndexDefinition indexDefinition
    //                 = new IndexDefinition(IndexDefinition.Type.JSON)
    //                 .setPrefixes(new String[] {"post:"});

    //         jedis.ftCreate("post-idx",
    //                 IndexOptions.defaultOptions().setDefinition(indexDefinition),
    //                 schema);
    //     };
    // }

	// @Bean
    // CommandLineRunner testRedis() {
    //     return args -> {		
    //         // Store & Retrieve a simple string
    //         jedis.set("foo", "bar");
    //         System.out.println(jedis.get("foo")); // prints bar
            
    //         // Store & Retrieve a HashMap
    //         Map<String, String> hash = new HashMap<>();;
    //         hash.put("name", "John");
    //         hash.put("surname", "Smith");
    //         hash.put("company", "Redis");
    //         hash.put("age", "29");
    //         jedis.hset("user-session:123", hash);
    //         System.out.println(jedis.hgetAll("user-session:123"));
    //         // Prints: {name=John, surname=Smith, company=Redis, age=29}
	// 	};
	// }

	// @Bean
    // CommandLineRunner testHttpClient() {
    //     return args -> {	
    //         //httpClientService.invokeGetAsync();
    //         //httpClientService.invokePostJSON();

    //         //apacheHttpClientService.invokeGetAsync();
    //         //apacheHttpClientService.invokePostJSON();
            
    //         //okHttpClientService.invokeGetAsync();
    //         //okHttpClientService.invokePostJSON();
            
    //         //webClientService.invokeGetAsync();
    //         //webClientService.invokePostJSON();   
            
    //         //OkHttpClientService2 okHttpClientService2 = new OkHttpClientService2();
    //         //okHttpClientService2.RestTest1();
    //         //okHttpClientService2.RestTest2();

    //         // HttpClientService2 httpClientService2 = new HttpClientService2();
    //         // httpClientService2.testGetSync();
    //         //httpClientService2.testGetAsync();
    //         //httpClientService2.testGetConcurrent();
    //         //httpClientService2.testPostForm();
    //         //httpClientService2.testPostJSON();
            
            
	// 	};
	// }        
        
	// @Bean
    // CommandLineRunner testDB() {
    //     return args -> {	
    //         // JDBCExample example = new JDBCExample();
    //         // example.testDBConn(databaseProperties);       
            
    //         example2.testDBConn();   

	// 	};
	// }           


	@Bean
    CommandLineRunner testFileOps() {
        return args -> {	
            //fileWriteService.testFileWrite();
            //fileWriteService.testFileWrite2();
            fileWriteService.testFileWrite3();

		};
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

		// Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
		
		// logger.trace("A TRACE Message");
        // logger.debug("A DEBUG Message");
        // logger.info("An INFO Message");
        // logger.warn("A WARN Message");
        // logger.error("An ERROR Message");        

	}	
	}
        

