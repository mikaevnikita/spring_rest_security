package ru.mikaev.dto;

import ru.mikaev.entities.User;

public class UserDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static UserDto fromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
