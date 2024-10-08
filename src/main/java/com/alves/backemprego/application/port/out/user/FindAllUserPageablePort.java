package com.alves.backemprego.application.port.out.user;

import com.alves.backemprego.application.domain.model.UserPage;

public interface FindAllUserPageablePort {

    UserPage findAllUsuario(Integer page, Integer pageSize);
}
