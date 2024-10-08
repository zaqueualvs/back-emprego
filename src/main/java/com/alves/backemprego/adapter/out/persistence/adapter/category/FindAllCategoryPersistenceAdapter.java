package com.alves.backemprego.adapter.out.persistence.adapter.category;

import com.alves.backemprego.adapter.out.persistence.mapper.CategoryPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.CategoryRepository;
import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.port.out.category.FindAllCategoryPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindAllCategoryPersistenceAdapter implements FindAllCategoryPort {

    private final CategoryRepository categoryRepository;
    private final CategoryPersistenceMapper categoryPersistenceMapper;


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll()
                .stream().map(categoryPersistenceMapper::toDomain)
                .toList();
    }
}
