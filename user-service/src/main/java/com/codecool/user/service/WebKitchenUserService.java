package com.codecool.user.service;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.repository.WebKitchenUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebKitchenUserService {

    private final WebKitchenUserRepository webKitchenUserRepository;

    public WebKitchenUserService(WebKitchenUserRepository webKitchenUserRepository) {
        this.webKitchenUserRepository = webKitchenUserRepository;
    }

    public void addUser(WebKitchenUser user) {
        webKitchenUserRepository.save(user);
    }

    public List<WebKitchenUser> getAllUsers() {
        return webKitchenUserRepository.findAll();
    }
}
