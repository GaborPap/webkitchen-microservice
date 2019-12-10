package com.codecool.user.service;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.repository.WebKitchenUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebKitchenUserService {

   @Autowired
   private WebKitchenUserRepository webKitchenUserRepository;

    public void addUser(WebKitchenUser user) {
        webKitchenUserRepository.save(user);
    }

    public List<WebKitchenUser> getAllUsers() {
        return webKitchenUserRepository.findAll();
    }

    public Optional<WebKitchenUser> getUserByUsername(String username){
        return webKitchenUserRepository.findAllByUsername(username);
    }
}
