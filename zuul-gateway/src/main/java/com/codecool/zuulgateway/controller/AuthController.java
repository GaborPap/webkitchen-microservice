package com.codecool.zuulgateway.controller;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.service.WebKitchenUserService;
import com.codecool.zuulgateway.security.JwtTokenServices;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;git
import org.springframework.web.client.RestTemplate;

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

    private RestTemplate restTemplate = new RestTemplate();



    @PostMapping("/register")
    public ResponseEntity signup(@RequestBody WebKitchenUser webKitchenUser, HttpServletResponse response) {

            String s = "http://localhost:8071/user/check/"+webKitchenUser.getUsername()+"/"+webKitchenUser.getEmail();

            ResponseEntity<String> response1 = restTemplate.exchange(
                    "http://localhost:8071/user/check/"+webKitchenUser.getUsername()+"/"+webKitchenUser.getEmail(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<String>() {
                    }
            );


        String errorMessage = response1.getBody();
        System.out.println(errorMessage);
        if (errorMessage!=null) {
            return new ResponseEntity<>(errorMessage, HttpStatus.CREATED);
        }

        webKitchenUser.setName(webKitchenUser.getUsername());
        webKitchenUser.setRoles(Collections.singletonList("ROLE_USER"));
        HttpEntity<WebKitchenUser> request = new HttpEntity<>(webKitchenUser);
        restTemplate.postForObject("http://localhost:8071/user/", request, WebKitchenUser.class);

        String token = createToken(webKitchenUser, Collections.singletonList("ROLE_USER"));
        Map<Object, Object> model = new HashMap<>();
        model.put("username", webKitchenUser.getUsername());
        model.put("role",Collections.singletonList("ROLE_USER"));
        model.put("token", token);

        return ResponseEntity.ok(model);

    }

    @PostMapping("/login")
    public ResponseEntity signin(@RequestBody WebKitchenUser userData, HttpServletResponse response) {


        String token = createToken(userData,null);
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userData.getUsername());
        model.put("name", userData.getName());
        model.put("role",getRoles(userData, userData.getUsername()));
        model.put("token", token);

        return ResponseEntity.ok(model);
    }

    private String createToken(WebKitchenUser userData, List<String> roles){
        String username = userData.getUsername();
        if (roles==null) {
           getRoles(userData, username);
        }
        return jwtTokenServices.createToken(username, roles);
    }

    private List<String> getRoles(WebKitchenUser userData, String username){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userData.getPassword()));
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

}