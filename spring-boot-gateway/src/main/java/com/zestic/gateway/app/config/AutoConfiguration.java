package com.zestic.gateway.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Order(1)
@Configuration
@ComponentScan
@Profile("!test")
@EnableMongoRepositories(basePackages = {"com.zestic.gateway.app"})
public class AutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(AutoConfiguration.class.getSimpleName());

    public AutoConfiguration() {
    }
}
