package com.codecool.webkitchen.service;

import com.codecool.user.model.WebKitchenUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class WebKitchenUserService {


    @Autowired
    private RestTemplate restTemplate;


    @Value("${users.url}")
    private String userUrl;

    public WebKitchenUser addUser(WebKitchenUser webkitchenUser) {
        HttpEntity<WebKitchenUser> request = new HttpEntity<>(webkitchenUser);
        return restTemplate.postForObject( userUrl+ "/", request, WebKitchenUser.class);

    }

    public List<WebKitchenUser> getAllUsers() {
        ResponseEntity<List<WebKitchenUser>> response = restTemplate.exchange(
                userUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WebKitchenUser>>() {
                }
        );
        return response.getBody();
    }

    public WebKitchenUser getUserByUsername(String username) {
      //  return webKitchenUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return restTemplate.getForEntity(userUrl+"/"+username, WebKitchenUser.class).getBody();
    }

    public String encodePassword(String password) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return passwordEncoder.encode(password);
    }

    public String checkUsernameAndPasswordPersent(String username, String email) {
      return restTemplate.getForEntity(userUrl+"/"+username+"/"+email, String.class).getBody();

    }

    public void changeAllowed(Long userId, Boolean allowed) {
       restTemplate.getForEntity(userUrl+"/"+userId+"/"+allowed,Boolean.class).getBody();
    }

    public List getUserRoles(){
        return restTemplate.getForEntity(userUrl+"/userroles",List.class).getBody();
    }

    public Boolean updateUserRoles(Long userId, Map<String, Object> roles) {
        return Objects.requireNonNull(restTemplate.postForObject(userUrl + "/userroles/" + userId, roles, Boolean.class));



    }

}
