package com.codecool.zuulgateway.security;

import com.codecool.user.model.WebKitchenUser;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

RestTemplate restTemplate = new RestTemplate();
    public WebKitchenUser getUserByname(String name){

        ResponseEntity<WebKitchenUser> response = restTemplate.exchange(
                "http://localhost:8071/user/"+name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<WebKitchenUser>() {
                }
        );
        return response.getBody();
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebKitchenUser user = getUserByname(username);//.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        return new User(user.getUsername(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
