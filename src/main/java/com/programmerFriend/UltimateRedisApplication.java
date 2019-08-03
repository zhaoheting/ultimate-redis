package com.programmerFriend;

import com.programmerFriend.service.CacheService;
import com.programmerFriend.service.ControlledCacheService;
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


//	public static void main(String[] args) {
//		SpringApplication.run(UltimateRedisApplication.class, args);
//	}
//
//	@Autowired
//	CacheService cacheService;
//
//
//	@Override
//	public void run(String... args) throws Exception {
//		String firstString = cacheService.cacheThis();
//		log.info("First: {}", firstString);
//		String secondString = cacheService.cacheThis();
//		log.info("Second: {}", secondString);
//	}
@Autowired
CacheService cacheService;

	@Autowired
	ControlledCacheService controlledCacheService;

	public static void main(String[] args) {
		SpringApplication.run(UltimateRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String firstString = cacheService.cacheThis("The content of cache.");
		log.info("First: {}", firstString);
		String secondString = cacheService.cacheThis("The content of cache.");
		log.info("Second: {}", secondString);

//		log.info("Starting controlled cache: -----------");
//		String controlledFirst = getFromControlledCache();
//		log.info("Controlled First: {}", controlledFirst);
//		String controlledSecond = getFromControlledCache();
//		log.info("Controlled Second: {}", controlledSecond);
		log.info("Clearing all cache entries:");
		cacheService.forgetAboutThis();
//		controlledCacheService.removeFromCache();
	}

	private String getFromControlledCache() {
		String fromCache = controlledCacheService.getFromCache();
		if (fromCache == null) {
			log.info("Oups - Cache was empty. Going to populate it");
			String newValue = controlledCacheService.populateCache();
			log.info("Populated Cache with: {}", newValue);
			return newValue;
		}
		log.info("Returning from Cache: {}", fromCache);
		return fromCache;
	}
}
