package com.alves.backemprego.application.domain.service.auth;

import com.alves.backemprego.application.domain.model.UserAuthentication;
import com.alves.backemprego.application.port.in.auth.AuthenticateUserUseCase;
import com.alves.backemprego.application.port.out.auth.AuthenticateUserPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthenticateUserService implements AuthenticateUserUseCase {

    private final AuthenticateUserPort authenticateUserPort;

    @Override
    public UserAuthentication authenticate(String login) {
        return authenticateUserPort.authenticate(login)
                .orElse(null);
    }
}
