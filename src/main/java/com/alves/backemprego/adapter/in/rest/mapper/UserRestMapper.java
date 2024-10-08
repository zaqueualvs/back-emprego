package com.alves.backemprego.adapter.in.rest.mapper;

import com.alves.backemprego.adapter.in.rest.data.request.AcademicDegreeRequest;
import com.alves.backemprego.adapter.in.rest.data.request.StatusRequest;
import com.alves.backemprego.adapter.in.rest.data.request.UserRegisterRequest;
import com.alves.backemprego.adapter.in.rest.data.request.UserRequest;
import com.alves.backemprego.adapter.in.rest.data.response.UserResponse;
import com.alves.backemprego.application.domain.model.Category;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.enums.AcademicDegree;
import com.alves.backemprego.application.domain.model.enums.Status;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    UserResponse toResponse(User user, @Context CycleAvoidingMappingContext context);

    User toModel(UserRegisterRequest userRegisterRequest);

    void copyProperties(UserRequest source, @MappingTarget User target);

    default Status statusRequestToStatus(StatusRequest statusRequest) {
        return Status.getStatus(statusRequest.cod());
    }

    default AcademicDegree academicDegreeRequestToAcademicDegree(AcademicDegreeRequest academicDegreeRequest) {
        return AcademicDegree.getAcademicDegree(academicDegreeRequest.cod());
    }

    default Set<Category> categoryLongToCategory(Set<Long> categories) {
        return categories.stream().map(id -> {
            Category category = new Category();
            category.setId(id);
            return category;
        }).collect(Collectors.toSet());
    }
}
