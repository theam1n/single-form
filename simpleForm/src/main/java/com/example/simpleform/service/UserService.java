package com.example.simpleform.service;

import com.example.simpleform.model.UserModel;
import com.example.simpleform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserModel registerUser(String login, String password,String email) {
        if(login == null || password == null ) {
            return null;
        }   else{
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return repository.save(userModel);
        }
    }

    public UserModel authenticate (String login, String password){
        return repository.findByLoginAndPassword(login, password).orElse(null);
    }


}
