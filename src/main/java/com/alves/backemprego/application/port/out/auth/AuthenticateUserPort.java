package com.alves.backemprego.application.port.out.auth;

import com.alves.backemprego.application.domain.model.UserAuthentication;

import java.util.Optional;

public interface AuthenticateUserPort {

    Optional<UserAuthentication> authenticate(String login);
}
