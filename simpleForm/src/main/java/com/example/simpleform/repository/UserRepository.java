package com.example.simpleform.repository;

import com.example.simpleform.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, String> {
    Optional<UserModel> findByLoginAndPassword(String login, String password);
}
