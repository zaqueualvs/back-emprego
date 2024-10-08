package com.alves.backemprego.application.port.out.user;

import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.domain.model.UserPage;

public interface FindUserByCategoryPort {

    UserPage findByCategory(Category category, Integer page, Integer pageSize);
}
