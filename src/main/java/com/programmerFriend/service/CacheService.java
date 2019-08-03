package com.programmerFriend.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    private static final String CONTROLLED_PREFIX = "myControlledPrefix_";

    public String generateCacheKey(String relevant) {
        return CONTROLLED_PREFIX + relevant;
    }

    @Cacheable(cacheNames = "myCache", key = "T(com.programmerFriend.service).generateCacheKey(#relevant)")
    public String cacheThis(String relevant) {
        LOGGER.info("Returning NOT from cache!");
        return "this Is it" + relevant;
    }

    @CacheEvict(cacheNames = "myCache")
    public void forgetAboutThis() {
        log.info("Forgetting everything about this!");
    }
}
