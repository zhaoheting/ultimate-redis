package com.programmerfriend;

import com.programmerfriend.com.programmerfriend.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
@EnableCaching
public class UltimateRedisApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(UltimateRedisApplication.class, args);
	}

	@Autowired
	CacheService cacheService;


	@Override
	public void run(String... args) throws Exception {
		String firstString = cacheService.cacheThis();
		log.info("First: {}", firstString);
		String secondString = cacheService.cacheThis();
		log.info("Second: {}", secondString);
	}
}
