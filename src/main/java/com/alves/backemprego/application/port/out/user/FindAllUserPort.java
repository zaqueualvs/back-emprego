package com.alves.backemprego.application.port.out.user;

import com.alves.backemprego.application.domain.model.User;

import java.util.List;

public interface FindAllUserPort {

    List<User> findAllUser();
}
