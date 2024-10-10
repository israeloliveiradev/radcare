package com.israeloliveiradev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userConfig {

    @Bean
    public userService userService(userRepository userRepository, userPort userPort){
        return new userServiceImpl(userRepository, userPort);
    }
}
