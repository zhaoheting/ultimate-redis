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

    @Cacheable(cacheNames = "myCache", key = "'myControlledPrefix_'.concat(#relevant)")
    public String cacheThis(String relevant, String irrelevantTrackingId) {
        LOGGER.info("Returning NOT from cache. irrelevant string:{}", irrelevantTrackingId);
        return relevant;
    }

    @CacheEvict(cacheNames = "myCache", key = "'myControlledPrefix_'.concat(#relevant)")
    public void forgetAboutThis(String relevant) {
        log.info("Forgetting everything about this relevant: '{}'!", relevant);
    }
}
