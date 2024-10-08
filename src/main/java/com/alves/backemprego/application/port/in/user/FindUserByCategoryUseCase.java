package com.alves.backemprego.application.port.in.user;

import com.alves.backemprego.application.domain.model.UserPage;

public interface FindUserByCategoryUseCase {

    UserPage findByCategory(Long categoryId, Integer page, Integer pageSize);
}
