package com.alves.backemprego.adapter.out.persistence.adapter.category;

import com.alves.backemprego.adapter.out.persistence.entity.CategoryEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CategoryPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.CategoryRepository;
import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.port.out.category.FindCategoryByIdPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindCategoryByIdPersistenceAdapter implements FindCategoryByIdPort {

    private final CategoryRepository categoryRepository;
    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public Optional<Category> findById(Long id) {

        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if (categoryEntity == null) {
            return Optional.empty();
        }
        Category category = categoryPersistenceMapper.toDomain(categoryEntity);
        return Optional.of(category);
    }
}
