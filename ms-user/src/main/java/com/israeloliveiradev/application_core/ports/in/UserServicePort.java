package com.israeloliveiradev.application_core.ports.in;

import com.israeloliveiradev.adapters.inbound.dtos.response.CompletedUserResponse;
import com.israeloliveiradev.application_core.domain.User;
import java.util.List;

public interface UserServicePort {

    User createUser(User user);

    List<User> findAllUsers();

    void deleteUser(Long id);

    User updateUser(Long id, User user);

    CompletedUserResponse getCompletedUserById(Long id);








}
