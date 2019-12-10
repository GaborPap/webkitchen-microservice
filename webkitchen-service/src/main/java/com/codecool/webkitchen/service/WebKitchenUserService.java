package com.codecool.webkitchen.service;

import com.codecool.user.model.WebKitchenUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WebKitchenUserService {

    private final RestTemplate restTemplate;


    @Value("${users.url}")
    private String usersUrl;

    public WebKitchenUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<WebKitchenUser> getAllUsers(){
        System.out.println("sélfsédjfslkdjfklsdjfklsdjfklsdjfklsjdflkjsdlkfjsdlkjflsdkfj");
        ResponseEntity<List<WebKitchenUser>> response = restTemplate.exchange(
                usersUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WebKitchenUser>>() {
                }
        );
        return response.getBody();
    }


}
