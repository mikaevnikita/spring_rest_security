package ru.mikaev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikaev.entities.Token;

import java.util.Optional;


public interface TokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}
