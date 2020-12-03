package com.codeacademy.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prisijungimas")
public class LoginController {

    @GetMapping
    public String login() {
        return "user/login";
    }
}
