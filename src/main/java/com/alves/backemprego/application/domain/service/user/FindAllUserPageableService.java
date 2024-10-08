package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.UserPage;
import com.alves.backemprego.application.port.in.user.FindAllUserPageableUseCase;
import com.alves.backemprego.application.port.out.user.FindAllUserPageablePort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class FindAllUserPageableService implements FindAllUserPageableUseCase {

    private final FindAllUserPageablePort findAllUserPageablePort;

    @Transactional
    @Override
    public UserPage findAllUser(Integer page, Integer pageSize) {
        return findAllUserPageablePort.findAllUsuario( page, pageSize);
    }
}
