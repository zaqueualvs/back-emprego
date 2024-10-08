package com.alves.backemprego.application.port.out.professionalexperience;

import com.alves.backemprego.application.domain.model.ProfessionalExperience;

public interface DeleteExperienceFromUserPort {

    void deleteExperienceFromUser(ProfessionalExperience professionalExperience);
}
