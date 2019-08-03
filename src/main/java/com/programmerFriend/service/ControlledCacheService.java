package com.programmerFriend.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ControlledCacheService {

    @Cacheable(cacheNames = "myControlledCache")
    public String getFromCache() {
        return null;
    }

    @CachePut(cacheNames = "myControlledCache")
    public String populateCache() {
        return "this is it again";
    }

    @CacheEvict(cacheNames = "myControlledCache")
    public void removeFromCache() {
    }
}
