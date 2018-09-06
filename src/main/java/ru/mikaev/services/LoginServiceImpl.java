package ru.mikaev.services;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.mikaev.dao.TokensRepository;
import ru.mikaev.dao.UsersRepository;
import ru.mikaev.dto.TokenDto;
import ru.mikaev.entities.Token;
import ru.mikaev.entities.User;
import ru.mikaev.forms.LoginForm;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByUsername(loginForm.getLogin());
        if(userCandidate.isPresent()){
            User user = userCandidate.get();
            if(passwordEncoder.matches(loginForm.getPassword(), user.getPassword())){
                Token token =
                        Token
                        .builder()
                        .user(user)
                                .value(RandomStringUtils.random(10, true, true)).build();
                tokensRepository.save(token);
                return TokenDto.fromToken(token);
            }
        }
        throw new UsernameNotFoundException("User not found: " + loginForm.getLogin());
    }
}
