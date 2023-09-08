package com.springwebapp.springwebapp.services.impl;

import com.springwebapp.springwebapp.dto.RegistrationDto;
import com.springwebapp.springwebapp.models.UserEntity;
import com.springwebapp.springwebapp.repository.RoleRepository;
import com.springwebapp.springwebapp.repository.UserRepository;
import com.springwebapp.springwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.springwebapp.springwebapp.models.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

   @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
