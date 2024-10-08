package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.user.LoadUserByLoginUseCase;
import com.alves.backemprego.application.port.out.user.LoadUserByLoginPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class LoadUserByLoginService implements LoadUserByLoginUseCase {

    private final LoadUserByLoginPort loadUserByLoginPort;

    @Transactional
    @Override
    public User loadByLogin(String email) {
        return loadUserByLoginPort.loadByLogin(email)
                .orElse(null);
    }
}
