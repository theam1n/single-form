package com.example.simpleform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users_table")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="login")
    String login;
    @Column(name="password")
    String password;
    @Column(name="email")
    String email;

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
