package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.user.FindUserByIdUseCase;
import com.alves.backemprego.application.port.out.user.FindUserByIdPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class FindUserByIdService implements FindUserByIdUseCase {

    private final FindUserByIdPort findUserByIdPort;

    @Transactional
    @Override
    public User findById(Long id) {
        return findUserByIdPort.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("User com id %s não encontrado", id))
        );
    }
}
