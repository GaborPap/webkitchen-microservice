package com.codecool.user;


import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DataInitilaizer implements CommandLineRunner {

    private WebKitchenUserService webKitchenUserService;

    public DataInitilaizer(WebKitchenUserService webKitchenUserService) {
        this.webKitchenUserService = webKitchenUserService;
    }

    @Override
    public void run(String... args) throws Exception {
        WebKitchenUser admin = WebKitchenUser.builder()
                .name("Kiss Lajos admin")
                .username("admin")
                .email("admin@admin.com")
                .password("admin")
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build();

        WebKitchenUser user = WebKitchenUser.builder()
                .name("Kiss Lajos user")
                .username("user")
                .email("user@user.hu")
                .password("user")
                .roles(Collections.singletonList("ROLE_USER"))
                .build();

        webKitchenUserService.addUser(admin);
        webKitchenUserService.addUser(user);
    }


}




