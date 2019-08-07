package com.programmerFriend.service;

import org.springframework.stereotype.Component;

@Component
public class ConfigService {
    private String userName;
    private int age;
    private String state;
    private String city;
    private String postcode;

    public String getUserName() {
        return "userName";
    }

    public int getAge() {
        return 2;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
}
