package com.alves.backemprego.adapter.out.persistence.adapter.auth;

import com.alves.backemprego.adapter.out.persistence.entity.UserAuthenticationEntity;
import com.alves.backemprego.adapter.out.persistence.repository.UserAuthenticationRepository;
import com.alves.backemprego.application.domain.model.UserAuthentication;
import com.alves.backemprego.application.port.out.auth.AuthenticateUserPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class AuthenticateUserPersistenceAdapter implements AuthenticateUserPort {
    private final UserAuthenticationRepository userAuthenticationRepository;

    @Override
    public Optional<UserAuthentication> authenticate(String login) {
        UserAuthenticationEntity entity = userAuthenticationRepository.findByEmail(login).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(new UserAuthentication(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getRole()));
    }
}
