package com.codecool.zuulgateway.controller;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import com.codecool.zuulgateway.security.JwtTokenServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://127.0.0.1:3000","http://localhost:3000"} )
public class AuthController {

   WebKitchenUserService webKitchenUserService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/register")
    public ResponseEntity signup(@RequestBody WebKitchenUser webKitchenUser, HttpServletResponse response) {
        webKitchenUser.setRoles(Collections.singletonList("ROLE_USER"));

        String errorMessage = webKitchenUserService.checkUsernameAndPasswordPersent(webKitchenUser.getUsername(), webKitchenUser.getEmail());
        if (errorMessage.length()>0) {
            return new ResponseEntity<>(errorMessage, HttpStatus.CREATED);
        }
        webKitchenUserService.addUser(webKitchenUser);
        String token = createToken(webKitchenUser, Collections.singletonList("ROLE_USER"));
        Map<Object, Object> model = new HashMap<>();
        model.put("username", webKitchenUser.getUsername());
        model.put("token", token);

        return ResponseEntity.ok(model);

    }

    @PostMapping("/login")
    public ResponseEntity signin(@RequestBody WebKitchenUser userData, HttpServletResponse response) {


        String token = createToken(userData,null);
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userData.getUsername());
        model.put("token", token);

        return ResponseEntity.ok(model);
    }

    private String createToken(WebKitchenUser userData, List<String> roles){
        String username = userData.getUsername();
        if (roles==null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userData.getPassword()));
            roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }
        return jwtTokenServices.createToken(username, roles);
    }
}