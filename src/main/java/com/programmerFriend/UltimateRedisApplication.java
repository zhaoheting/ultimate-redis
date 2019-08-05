package com.programmerFriend;

import com.programmerFriend.service.CacheService;
import com.programmerFriend.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.UUID;

@SpringBootApplication
@Slf4j
@EnableCaching
public class UltimateRedisApplication implements CommandLineRunner {
    @Autowired
    CacheService cacheService;

    @Autowired
    ConfigService configService;

    public static void main(String[] args) {
        SpringApplication.run(UltimateRedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String userName = cacheService.cacheThis(configService.getUserName(), UUID.randomUUID().toString());
        log.info("User Name is: {}", userName);
        String userName2 = cacheService.cacheThis(configService.getUserName(), UUID.randomUUID().toString());
        log.info("User Name is: {}", userName2);

        String age = cacheService.cacheThis(String.valueOf(configService.getAge()), UUID.randomUUID().toString());
        log.info("Age is: {}", age);
        log.info("Clearing all cache entries:");
        cacheService.forgetAboutThis(userName2);
    }
}
