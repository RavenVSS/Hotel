package com.example.hotel.repository.users;

import com.example.hotel.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findOptionalByLogin(String login);
}
