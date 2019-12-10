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

    public String checkUsernameAndPasswordPersent(String username, String email) {
        boolean userNameExists = webKitchenUserRepository.findByUsername(username).isPresent();
        boolean emailExists = webKitchenUserRepository.findByEmail(email).isPresent();

        if (userNameExists && emailExists)
            return "Username and email address already taken";

        if (userNameExists)
            return "Username already taken";

        if (emailExists)
            return "Email address already taken";

        return "";
    }
}
