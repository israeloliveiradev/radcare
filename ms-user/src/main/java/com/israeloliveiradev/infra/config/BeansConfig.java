package com.israeloliveiradev.infra.config;

import com.israeloliveiradev.adapters.inbound.mapper.UserMapper;
import com.israeloliveiradev.adapters.outbound.feignClients.ViaCepClient;
import com.israeloliveiradev.adapters.outbound.repositories.UserRepository;
import com.israeloliveiradev.application_core.ports.in.UserServicePort;
import com.israeloliveiradev.application_core.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public UserServicePort userServiceImpl(UserRepository userRepository, ViaCepClient viaCepClient, UserMapper userMapper) {
        return new UserService(userRepository, viaCepClient, userMapper);
    }

}
