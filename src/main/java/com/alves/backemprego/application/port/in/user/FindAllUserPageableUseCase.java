package com.alves.backemprego.application.port.in.user;

import com.alves.backemprego.application.domain.model.UserPage;

public interface FindAllUserPageableUseCase {

    UserPage findAllUser(Integer page, Integer pageSize);
}
