package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.domain.model.UserPage;
import com.alves.backemprego.application.port.in.category.FindCategoryByIdUseCase;
import com.alves.backemprego.application.port.in.user.FindUserByCategoryUseCase;
import com.alves.backemprego.application.port.out.user.FindUserByCategoryPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class FindUserByCategoryService implements FindUserByCategoryUseCase {

    private final FindUserByCategoryPort findUserByCategoryPort;
    private final FindCategoryByIdUseCase findCategoryByIdUseCase;

    @Transactional
    @Override
    public UserPage findByCategory(Long categoriaId, Integer page, Integer pageSize) {
        Category category = findCategoryByIdUseCase.findById(categoriaId);
        return findUserByCategoryPort.findByCategory(category, page, pageSize);
    }
}
