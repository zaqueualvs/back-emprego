package com.alves.backemprego.application.domain.service.categoria;

import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.port.in.category.FindCategoryByIdUseCase;
import com.alves.backemprego.application.port.out.category.FindCategoryByIdPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindCategoryByIdService implements FindCategoryByIdUseCase {

    private final FindCategoryByIdPort findCategoryByIdPort;

    @Override
    public Category findById(Long id) {
        return findCategoryByIdPort.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Categoria com id %d não encontrado", id))
        );
    }
}
