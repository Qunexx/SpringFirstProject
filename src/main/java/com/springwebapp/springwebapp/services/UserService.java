package com.springwebapp.springwebapp.services;

import com.springwebapp.springwebapp.dto.RegistrationDto;
import com.springwebapp.springwebapp.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
