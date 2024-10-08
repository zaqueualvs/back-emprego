package com.alves.backemprego.adapter.out.persistence.mapper;

import com.alves.backemprego.adapter.out.persistence.entity.CategoryEntity;
import com.alves.backemprego.application.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryPersistenceMapper {

    CategoryEntity toEntity(Category category);

    Category toDomain(CategoryEntity categoryEntity);
}
