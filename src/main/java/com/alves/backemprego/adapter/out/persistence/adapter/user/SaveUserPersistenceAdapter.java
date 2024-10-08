package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.out.user.SaveUserPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveUserPersistenceAdapter implements SaveUserPort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userPersistenceMapper.toEntity(user, new CycleAvoidingMappingContext());
        userEntity = userRepository.save(userEntity);
        user = userPersistenceMapper.toDomain(userEntity, new CycleAvoidingMappingContext());
        return user;
    }
}
