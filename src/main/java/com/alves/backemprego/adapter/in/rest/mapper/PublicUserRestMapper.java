package com.alves.backemprego.adapter.in.rest.mapper;

import com.alves.backemprego.adapter.in.rest.data.response.ProfessionalExperienceResponse;
import com.alves.backemprego.adapter.in.rest.data.response.PublicUserResponse;
import com.alves.backemprego.application.domain.model.ProfessionalExperience;
import com.alves.backemprego.application.domain.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicUserRestMapper {


    PublicUserResponse toResponse(User user, @Context CycleAvoidingMappingContext context);

    //@Mapping(source = "current", target = "current")
    ProfessionalExperienceResponse professionalExperienceToProfessionalExperienceResponse(ProfessionalExperience professionalExperience, CycleAvoidingMappingContext context);

}
