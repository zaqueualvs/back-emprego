package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.CategoryEntity;
import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CategoryPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.UserPage;
import com.alves.backemprego.application.port.out.user.FindUserByCategoryPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindUserByCategoryPersistenceAdapter implements FindUserByCategoryPort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;
    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public UserPage findByCategory(Category category, Integer page, Integer pageSize) {

        CategoryEntity categoryEntity = categoryPersistenceMapper.toEntity(category);

        Page<UserEntity> userEntityPage = userRepository.findByCategory(categoryEntity, PageRequest.of(page, pageSize));

        List<User> users = userEntityPage.get()
                .map(userEntity -> userPersistenceMapper.toDomain(userEntity, new CycleAvoidingMappingContext()))
                .toList();

        return new UserPage(users, userEntityPage.getTotalElements(), userEntityPage.getTotalPages());

    }
}
