package com.alves.backemprego.adapter.in.rest.data.request;

import java.util.Set;

public record ResumeRequest(
        Long id,
        Set<ProfessionalExperienceRequest> professionalExperiences,
        Set<EducationRequest> educations) {
}
