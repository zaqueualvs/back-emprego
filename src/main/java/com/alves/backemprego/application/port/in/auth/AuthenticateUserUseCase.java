package com.alves.backemprego.application.port.in.auth;

import com.alves.backemprego.application.domain.model.UserAuthentication;

public interface AuthenticateUserUseCase {

    UserAuthentication authenticate(String login);
}
