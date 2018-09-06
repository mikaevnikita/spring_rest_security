package ru.mikaev.dto;

import lombok.Data;
import ru.mikaev.entities.User;

@Data
public class UserDto {
    private String username;

    public static UserDto fromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
