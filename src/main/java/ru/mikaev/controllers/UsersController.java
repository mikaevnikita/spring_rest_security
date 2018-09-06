package ru.mikaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mikaev.dao.UsersRepository;
import ru.mikaev.dto.UserDto;
import ru.mikaev.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    UsersRepository userRepository;

    @GetMapping("/users/{user-id}")
    UserDto getUser(@PathVariable("user-id") Long userId){
        Optional<User> user = userRepository.findById(userId);
        return UserDto.fromUser(user.get());
    }

    @GetMapping("/users")
    List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(UserDto.fromUser(user));
        }
        return userDtos;
    }

    @PostMapping("/users")
    ResponseEntity<Object> addUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
