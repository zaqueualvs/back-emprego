package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.out.user.FindUserByIdPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindUserByIdPersistenceAdapter implements FindUserByIdPort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public Optional<User> findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) {
            return Optional.empty();
        }
        return Optional.of(userPersistenceMapper.toDomain(userEntity, new CycleAvoidingMappingContext()));
    }
}
