package com.alves.backemprego.adapter.out.persistence.mapper;

import com.alves.backemprego.adapter.out.persistence.entity.UserEntity;
import com.alves.backemprego.application.domain.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserEntity toEntity(User user, @Context CycleAvoidingMappingContext context);

    User toDomain(UserEntity userEntity, @Context CycleAvoidingMappingContext context);
}
