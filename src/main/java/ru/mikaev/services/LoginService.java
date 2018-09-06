package ru.mikaev.services;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikaev.dto.TokenDto;
import ru.mikaev.forms.LoginForm;

public interface LoginService{
    TokenDto login(LoginForm loginForm);
}
