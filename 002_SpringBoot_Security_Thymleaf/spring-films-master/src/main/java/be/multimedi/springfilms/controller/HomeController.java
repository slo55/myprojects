package be.multimedi.springfilms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // @Controller = @Component + auto-configuratie van Spring Web + semantische betekenis
public class HomeController {

    @GetMapping("/")
    public String fetchHomePage(){
        return "home";
    }
}
