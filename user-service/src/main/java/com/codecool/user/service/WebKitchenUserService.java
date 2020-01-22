package com.codecool.user.service;

import com.codecool.user.model.WebKitchenUser;
import com.codecool.user.repository.WebKitchenUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WebKitchenUserService {

   @Autowired
   private WebKitchenUserRepository webKitchenUserRepository;

    public void addUser(WebKitchenUser user) {
        user.setPassword(encodePassword(user.getPassword()));
        webKitchenUserRepository.save(user);
    }

    public List<WebKitchenUser> getAllUsers() {
        return webKitchenUserRepository.findAll();
    }

    public Optional<WebKitchenUser> getUserByUsername(String username){
        return webKitchenUserRepository.findByUsername(username);
    }

    public Optional<WebKitchenUser> getUserById(Long userId){
        return webKitchenUserRepository.findById(userId);
    }

    public String encodePassword(String password) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return passwordEncoder.encode(password);
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
    public void changeAllowed(Long userId, Boolean allowed) {
        webKitchenUserRepository.updateAllowed(userId, allowed);
    }

    public Boolean updateUserRoles(Long userId, Map<String, Object> roles) {
        ArrayList<String> rolesArray = getRolesArrayFromObject(roles);
        if (rolesArray.size() > 0) {
            List<String> roleList = new ArrayList<>();
            for (String role : rolesArray)
                roleList.add("ROLE_" + role);
            Optional<WebKitchenUser> webKitchenUser = webKitchenUserRepository.findById(userId);
            if (webKitchenUser.isPresent()) {
                WebKitchenUser tmp = webKitchenUser.get();
                tmp.setRoles(roleList);
                webKitchenUserRepository.save(tmp);
            }
            return true;
        }
        return false;
    }

    private ArrayList<String> getRolesArrayFromObject(Map<String, Object> roles) {
        ArrayList<String> rolesArray = new ArrayList<>();
        try {
            rolesArray = (ArrayList<String>) roles.get("userRoles") == null ? new ArrayList<>() : (ArrayList<String>) roles.get("userRoles");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rolesArray;
    }
}
