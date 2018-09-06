package ru.mikaev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mikaev.entities.Token;

@Data
@AllArgsConstructor
public class TokenDto {
    private String value;

    public static TokenDto fromToken(Token token){
        return new TokenDto(token.getValue());
    }
}
