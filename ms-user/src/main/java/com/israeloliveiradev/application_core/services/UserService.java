package com.israeloliveiradev.application_core.services;

import com.israeloliveiradev.adapters.inbound.dtos.response.AddressResponse;
import com.israeloliveiradev.adapters.inbound.dtos.response.CompletedUserResponse;
import com.israeloliveiradev.adapters.inbound.mapper.UserMapper;
import com.israeloliveiradev.adapters.outbound.feignClients.ViaCepClient;
import com.israeloliveiradev.adapters.outbound.repositories.UserRepository;
import com.israeloliveiradev.application_core.domain.User;
import com.israeloliveiradev.application_core.ports.in.UserServicePort;
import com.israeloliveiradev.exceptions.ObjectNotFoundException;

import java.util.List;


public class UserService implements UserServicePort {

    private final UserRepository userRepository;
    private final ViaCepClient viaCepClient;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, ViaCepClient viaCepClient, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.viaCepClient = viaCepClient;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ObjectNotFoundException("Object not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setBirthDate(user.getBirthDate());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setDocumentId(user.getDocumentId());
        userToUpdate.setZipCode(user.getZipCode());

        return userRepository.save(userToUpdate);
    }

    @Override
    public CompletedUserResponse getCompletedUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

        AddressResponse address = viaCepClient.getAddressByZipCode(user.getZipCode());

        return userMapper.toCompletedUserResponse(user, address);
    }
}


