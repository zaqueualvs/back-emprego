package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.out.user.FindAllUserPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindAllUserPersistenceAdapter implements FindAllUserPort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public List<User> findAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();


        return userEntities.stream().map(
                userEntity -> userPersistenceMapper
                        .toDomain(userEntity, new CycleAvoidingMappingContext())
        ).toList();
    }
}
