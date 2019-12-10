package com.codecool.zuulgateway.security;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private WebKitchenUserService webKitchenUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebKitchenUser user = webKitchenUserService.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        return new User(user.getUsername(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
