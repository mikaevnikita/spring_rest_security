package ru.mikaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mikaev.dto.TokenDto;
import ru.mikaev.forms.LoginForm;
import ru.mikaev.services.LoginService;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm);
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
