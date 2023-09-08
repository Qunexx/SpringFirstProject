package com.springwebapp.springwebapp.repository;

import com.springwebapp.springwebapp.models.Role;
import com.springwebapp.springwebapp.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);

}
