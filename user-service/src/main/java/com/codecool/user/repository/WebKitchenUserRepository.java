package com.codecool.user.repository;


import com.codecool.user.model.WebKitchenUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebKitchenUserRepository extends JpaRepository<WebKitchenUser, Long> {

}
