package com.programmerfriend.com.programmerfriend.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @Cacheable(cacheNames = "myCache")
    public String cacheThis(){
        LOGGER.info("Returning NOT from cache!");
        return "this Is it";
    }
}
