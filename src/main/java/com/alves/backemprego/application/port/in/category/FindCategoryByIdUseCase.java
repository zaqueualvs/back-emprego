package com.alves.backemprego.application.port.in.category;

import com.alves.backemprego.application.domain.model.Category;

public interface FindCategoryByIdUseCase {

    Category findById(Long id);
}
