package com.codecool.user.controller;


import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class WebKitchenUserController {

    private final WebKitchenUserService webKitchenUserService;

    public WebKitchenUserController(WebKitchenUserService webKitchenUserService) {
        this.webKitchenUserService = webKitchenUserService;
    }

    @GetMapping("/")
    public List<WebKitchenUser> getAllUsers(){
        return webKitchenUserService.getAllUsers();
    }
}
