package com.alves.backemprego.application.port.in.user;

import com.alves.backemprego.application.domain.model.User;

public interface FindUserByIdUseCase {
    User findById(Long id);
}
