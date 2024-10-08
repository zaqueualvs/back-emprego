package com.alves.backemprego.adapter.out.persistence.adapter.user;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.adapter.out.persistence.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.alves.backemprego.adapter.out.persistence.repository.UserRepository;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.out.user.LoadUserByLoginPort;
import com.alves.backemprego.common.custonannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadUserByLoginPersistenceAdapter implements LoadUserByLoginPort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public Optional<User> loadByLogin(String login) {
        UserEntity userEntity = userRepository.loadByEmail(login).orElse(null);
        if (userEntity == null) {
            return Optional.empty();
        }
        User user = userPersistenceMapper.toDomain(userEntity, new CycleAvoidingMappingContext());
        return Optional.of(user);
    }
}
