package com.alves.backemprego.application.domain.service.categoria;

import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.port.in.category.FindAllCategoryUseCase;
import com.alves.backemprego.application.port.out.category.FindAllCategoryPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class FindAllCategoryService implements FindAllCategoryUseCase {

    private final FindAllCategoryPort findAllCategoryPort;

    @Override
    public List<Category> findAllCategory() {
        return findAllCategoryPort.findAllCategory();
    }
}
