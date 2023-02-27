package com.soysaltech.bankeroApp.controller;

import com.soysaltech.bankeroApp.entity.User;
import com.soysaltech.bankeroApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProfileController
{
    private final UserService userService;

    @GetMapping("/profile")
    public String fetchProfilePage(Model model, Principal principal)
    {
        User loggedUser = userService.getUserByIBAN(principal.getName());
        model.addAttribute("user", loggedUser);
        return "profile";
    }

    @GetMapping("/send-money")
    public String fetchSendMoney()
    {
        return "send-money";
    }

    @GetMapping("/aboutMe")
    public String fetchAboutMePage()
    {
        return "aboutme";
    }


}
