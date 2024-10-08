package com.alves.backemprego.application.port.in.auth;

import com.alves.backemprego.application.domain.model.User;

public interface AuthUseCase {
    User getCurrentUser();
}
