package com.springwebapp.springwebapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDto {
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
