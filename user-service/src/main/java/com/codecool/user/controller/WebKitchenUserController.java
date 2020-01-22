package com.codecool.user.controller;


import com.codecool.user.model.UserRole;
import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{userId]")
    public WebKitchenUser getUserById(@PathVariable("userId") Long userId){
        return  webKitchenUserService.getUserById(userId).orElse(null);
    }

    @GetMapping("/check/{username}/{email}")
    public String checkUserExists(@PathVariable("username") String username, @PathVariable("email") String email){
        return webKitchenUserService.checkUsernameAndPasswordPersent(username, email);
    }

    @GetMapping("/{userId}/{allowed}")
    public HttpEntity setAllowed(@PathVariable("userId") Long userId, @PathVariable("allowed") Boolean allowed )
    {
        webKitchenUserService.changeAllowed(userId, allowed);
        return new HttpEntity(true);
    }

    @GetMapping("/userroles")
    public UserRole[] getRoles(){

        return UserRole.values();
    }

    @PostMapping("/userroles/{userId}")
    public HttpEntity setUserRoles1(@PathVariable("userId") Long userId, @RequestBody Map<String, Object> roles ){
        if (webKitchenUserService.updateUserRoles(userId, roles))
            return new HttpEntity(true);
        return new HttpEntity(false);
    }
}
