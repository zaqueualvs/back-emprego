package com.alves.backemprego.adapter.in.rest.data.response;

import java.util.Set;

public record ResumeResponse(
        Long id,
        Set<ProfessionalExperienceResponse> professionalExperiences,
        Set<EducationResponse> educations) {
}
