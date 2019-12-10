package com.codecool.user.repository;


import com.codecool.user.model.WebKitchenUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebKitchenUserRepository extends JpaRepository<WebKitchenUser, Long> {

    Optional<WebKitchenUser> findAllByUsername(String username);
}
