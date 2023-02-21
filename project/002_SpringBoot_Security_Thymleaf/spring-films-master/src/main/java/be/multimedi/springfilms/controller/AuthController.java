package be.multimedi.springfilms.controller;

import be.multimedi.springfilms.model.User;
import be.multimedi.springfilms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller                     // @Component dispather server does registration
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
        model.addAttribute("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String processRegistration(User user)
    {
        userService.registerNewUser(user);
        return "redirect:/login";
    }


}
