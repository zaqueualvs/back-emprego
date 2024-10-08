package com.alves.backemprego.application.port.out.user;

import com.alves.backemprego.application.domain.model.User;

import java.util.Optional;

public interface LoadUserByLoginPort {

    Optional<User> loadByLogin(String login);
}
