package com.example.simpleform.controller;


import com.example.simpleform.model.UserModel;
import com.example.simpleform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService service;
    private final UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @PostMapping( value = "/register")
    public ResponseEntity<String> register(@RequestBody UserModel userModel){
        System.out.println("Request register" + userModel);
        UserModel registeredUser =userService.registerUser(userModel.getLogin(), userModel.getPassword(),userModel.getEmail());
        if (registeredUser != null) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false}");
        }
    }
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserModel userModel){
        System.out.println("login request: " + userModel);

        UserModel authenticatedUser = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false}");
        }

    }

    @GetMapping("/personal_page")
    public String showPersonalPage() {
        return "personal_page";
    }

    @GetMapping("/error_page")
    public String showErrorPage() {
        return "error_page";
    }
}
