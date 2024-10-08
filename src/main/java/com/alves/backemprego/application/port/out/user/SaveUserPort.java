package com.alves.backemprego.application.port.out.user;

import com.alves.backemprego.application.domain.model.User;

public interface SaveUserPort {

    User save(User user);
}
