package com.codecool.user.controller;


import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{username}")
    public WebKitchenUser getUserByname(@PathVariable("username") String username){
        return webKitchenUserService.getUserByUsername(username).orElse(null);
    }

    @PostMapping("/")
    public WebKitchenUser addNewUser(@RequestBody WebKitchenUser webKitchenUser){
        webKitchenUserService.addUser(webKitchenUser);
        return webKitchenUser;
    }

}
