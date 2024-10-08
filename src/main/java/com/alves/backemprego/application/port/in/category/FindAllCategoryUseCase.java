package com.alves.backemprego.application.port.in.category;

import com.alves.backemprego.application.domain.model.Category;

import java.util.List;

public interface FindAllCategoryUseCase {

    List<Category> findAllCategory();

}
