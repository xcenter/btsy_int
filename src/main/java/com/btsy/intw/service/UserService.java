package com.btsy.intw.service;

import com.btsy.intw.domain.User;
import com.btsy.intw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> User.builder().id(userEntity.getId()).name(userEntity.getName()).build())
                .collect(Collectors.toList());
    }
}
