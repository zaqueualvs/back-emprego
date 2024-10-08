package com.alves.backemprego.application.port.out.category;

import com.alves.backemprego.application.domain.model.Category;

import java.util.List;

public interface FindAllCategoryPort {

    List<Category> findAllCategory();

}
