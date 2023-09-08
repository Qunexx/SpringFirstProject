package com.springwebapp.springwebapp.controllers;

import com.springwebapp.springwebapp.dto.RegistrationDto;
import com.springwebapp.springwebapp.models.UserEntity;
import com.springwebapp.springwebapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model){
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if(existingUserEmail != null) //&& existingUserEmail.getEmail() != null)
        {
            result.hasErrors();
        }
        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if(existingUserUsername != null) //&& existingUserUsername.getUsername() != null)
        {
            result.hasErrors();

        }
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/register?unsuccess";
        }
        else{userService.saveUser(user);
            return "redirect:/clubs?success";
        }


    }


}
