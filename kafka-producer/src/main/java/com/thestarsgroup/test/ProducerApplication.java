package com.thestarsgroup.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) throws UnknownHostException {

        SpringApplication app = new SpringApplication(ProducerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        Environment env = app.run(args).getEnvironment();

        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
        return mongoTemplate;

    }

}
