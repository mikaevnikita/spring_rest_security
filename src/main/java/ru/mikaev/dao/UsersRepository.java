package ru.mikaev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikaev.entities.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
