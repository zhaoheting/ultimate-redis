package com.programmerFriend.service;

import org.springframework.stereotype.Component;

@Component
public class ConfigService {
    private String userName;
    private int age;

    public String getUserName() {
        return "userName";
    }

    public int getAge() {
        return 2;
    }
}
