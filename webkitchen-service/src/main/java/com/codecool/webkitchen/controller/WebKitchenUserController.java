package com.codecool.webkitchen.controller;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.webkitchen.service.WebKitchenUserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return webKitchenUserService.getUserByUsername(username);
    }

    @PostMapping("/")
    public WebKitchenUser addNewUser(@RequestBody WebKitchenUser webKitchenUser){
        webKitchenUserService.addUser(webKitchenUser);
        return webKitchenUser;
    }

    @GetMapping("/check/{username}/{email}")
    public String checkUserExists(@PathVariable("username") String username, @PathVariable("email") String email){
        return webKitchenUserService.checkUsernameAndPasswordPersent(username, email);
    }

    @GetMapping("/{userId}/{allowed}")
    public HttpEntity setAllowed(@PathVariable("userId") Long userId, @PathVariable("allowed") Boolean allowed )
    {
        webKitchenUserService.changeAllowed(userId, allowed);
        return new HttpEntity(HttpStatus.OK);
    }

    @GetMapping("/userroles")
    public List<String> getRoles(){
        System.out.println("sdfdsf");
        return webKitchenUserService.getUserRoles();
    }

    @PostMapping("/userroles/{userId}")
    public ResponseEntity setUserRoles1(@PathVariable("userId") Long userId, @RequestBody Map<String, Object> roles ){
         if (webKitchenUserService.updateUserRoles(userId, roles))
            return new ResponseEntity(true,HttpStatus.OK);
        return new ResponseEntity(false,HttpStatus.OK);
    }
}
