package com.springwebapp.springwebapp.repository;

import com.springwebapp.springwebapp.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String userName);

}
