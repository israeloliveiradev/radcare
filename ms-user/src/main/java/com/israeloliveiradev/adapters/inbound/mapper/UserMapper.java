package com.israeloliveiradev.adapters.inbound.mapper;


import com.israeloliveiradev.adapters.inbound.dtos.request.UserRequest;
import com.israeloliveiradev.adapters.inbound.dtos.response.AddressResponse;
import com.israeloliveiradev.adapters.inbound.dtos.response.CompletedUserResponse;
import com.israeloliveiradev.adapters.inbound.dtos.response.UserResponse;
import com.israeloliveiradev.application_core.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User toUser(UserRequest request) {
        return mapper.map(request, User.class);
    }

    public UserResponse toUserResponse(User user) {
        return mapper.map(user, UserResponse.class);
    }

    public List<UserResponse> toUserResponseList(List<User> users) {
        return users.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }

    public CompletedUserResponse toCompletedUserResponse(User user, AddressResponse address) {
        return CompletedUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthDate())
                .documentId(user.getDocumentId())
                .administrator(user.getAdministrator())
                .zipCode(user.getZipCode())
                .address(address.getLogradouro())
                .neighborhood(address.getBairro())
                .city(address.getLocalidade())
                .state(address.getUf())
                .build();
    }
}



