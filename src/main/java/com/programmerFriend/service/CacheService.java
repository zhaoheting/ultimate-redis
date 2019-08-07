package com.programmerFriend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {

    @Cacheable(cacheNames = "myCache", key = "'myPrefix_'.concat(#relevant)")
    public String cacheThis(String relevant, String irrelevantTrackingId) {
        log.info("Returning NOT from cache. irrelevant string:{}", irrelevantTrackingId);
        return "Try to get {} from cac he." + relevant;
    }

    @CachePut(cacheNames = "myCache", key = "'myPrefix_'.concat(#relevant)")
    public String populateCache(String relevant, String irrelevantTrackingId) {
        log.info("Returning NOT from cache. irrelevant string:{}", irrelevantTrackingId);
        return "Save and return: {}" + relevant;
    }

    @CacheEvict(cacheNames = "myCache", key = "'myPrefix_'.concat(#relevant)")
    public void forgetAboutThis(String relevant) {
        log.info("Forgetting everything about this relevant: '{}'!", relevant);
    }
}
