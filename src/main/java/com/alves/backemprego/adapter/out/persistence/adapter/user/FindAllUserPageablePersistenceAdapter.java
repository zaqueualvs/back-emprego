package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.UserPage;
import com.alves.backemprego.application.port.out.user.FindAllUserPageablePort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindAllUserPageablePersistenceAdapter implements FindAllUserPageablePort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public UserPage findAllUsuario(Integer page, Integer pageSize) {
        Page<UserEntity> userPage = userRepository.findAllByShowIsTrueAndDisplayIsTrue(PageRequest.of(page, pageSize));

        List<User> users = userPage.get().map(
                userEntity -> userPersistenceMapper
                        .toDomain(userEntity, new CycleAvoidingMappingContext())
        ).toList();

        return new UserPage(users, userPage.getTotalElements(), userPage.getTotalPages());
    }
}
