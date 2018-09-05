package ru.mikaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mikaev.dao.UserRepository;
import ru.mikaev.entities.Role;
import ru.mikaev.entities.User;

import java.util.Collections;
import java.util.Optional;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/signup")
    public String signup(Authentication authentication, Model model){
        if(authentication != null){
            return "redirect:/profile";
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(Authentication authentication, User user, Model model){
        if(authentication != null){
            return "redirect:/profile";
        }

        Optional<User> userFromDb = userRepository.findOneByUsername(user.getUsername());

        if(userFromDb.isPresent()){
            model.addAttribute("message", "User exists!");
            return "signup";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/signin";
    }
}
