package com.example.budget_app.repository;

import com.example.budget_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //Optional<User> findByUsernameAndPassword(String username, String password);
}
