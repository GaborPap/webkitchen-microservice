package com.codecool.user.repository;


import com.codecool.user.model.WebKitchenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface WebKitchenUserRepository extends JpaRepository<WebKitchenUser, Long> {

    Optional<WebKitchenUser> findById(Long userId);
    Optional<WebKitchenUser> findByUsername(String username);
    Optional<WebKitchenUser> findByEmail(String email);


    @Modifying
    @Transactional
    @Query(value = "UPDATE WebKitchenUser w SET w.allowed = :allowed WHERE w.id = :userId")
    void updateAllowed(@Param("userId") Long userId, @Param("allowed") Boolean allowed);

}
