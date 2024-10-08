package com.alves.backemprego.adapter.in.rest.mapper;

import com.alves.backemprego.adapter.in.rest.data.response.CategoryResponse;
import com.alves.backemprego.application.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryRestMapper {

    CategoryResponse toResponse(Category category);
}
