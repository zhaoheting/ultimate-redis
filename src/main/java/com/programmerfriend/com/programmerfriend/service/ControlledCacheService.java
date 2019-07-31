package com.programmerfriend.com.programmerfriend.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class ControlledCacheService {

    @Cacheable(cacheNames = "myControlledCache")
    public String getFromCache() {
        return null;
    }

    @CachePut(cacheNames = "myControlledCache")
    public String populateCache() {
        return "this is it again";
    }
}
