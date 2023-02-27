package com.soysaltech.bankeroApp.controller;

import com.soysaltech.bankeroApp.entity.User;
import com.soysaltech.bankeroApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController
{
    private final UserService userService;

    @GetMapping("/login")
    public String fetchLoginForm()
    {
        return "login-form";
    }

    @GetMapping("/register")
    public String fetchRegisterForm(Model model)
    {
        model.addAttribute("user",new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String processRegistration(User user)
    {
        userService.registerNewUser(user);
        return "redirect:/login";
    }


}
