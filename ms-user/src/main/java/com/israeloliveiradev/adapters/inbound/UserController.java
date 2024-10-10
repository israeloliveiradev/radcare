package com.israeloliveiradev.adapters.inbound;

import com.israeloliveiradev.adapters.inbound.dtos.request.UserRequest;
import com.israeloliveiradev.adapters.inbound.dtos.response.CompletedUserResponse;
import com.israeloliveiradev.adapters.inbound.dtos.response.UserResponse;
import com.israeloliveiradev.adapters.inbound.mapper.UserMapper;
import com.israeloliveiradev.adapters.outbound.repositories.UserRepository;
import com.israeloliveiradev.application_core.domain.User;
import com.israeloliveiradev.application_core.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UserController {


    private final UserMapper userMapper;

    private final UserServicePort userServicePort;

    @PostMapping
    public ResponseEntity<UserResponse> createNewUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User createdUser = userServicePort.createUser(user);
        UserResponse userResponse = userMapper.toUserResponse(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers(){
        List<UserResponse> userResponses = userServicePort.findAllUsers()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompletedUserResponse> getUserById(@PathVariable Long id) {
        CompletedUserResponse completedUserById = userServicePort.getCompletedUserById(id);
        return ResponseEntity.ok(completedUserById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser (@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User savedUser = userServicePort.updateUser(id, user);
        UserResponse userResponse = userMapper.toUserResponse(savedUser);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServicePort.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}



