package com.alves.backemprego.application.port.out.category;

import com.alves.backemprego.application.domain.model.Category;

import java.util.Optional;

public interface FindCategoryByIdPort {

    Optional<Category> findById(Long id);
}
