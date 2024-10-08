package com.alves.backemprego.application.domain.service.professionalexperience;

import com.alves.backemprego.application.domain.model.ProfessionalExperience;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.professionalexperience.DeleteExperienceFromUserUseCase;
import com.alves.backemprego.application.port.in.user.LoadUserByLoginUseCase;
import com.alves.backemprego.application.port.in.user.UpdateUserUseCase;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class DeleteExperienceFromUserService implements DeleteExperienceFromUserUseCase {

    private final LoadUserByLoginUseCase loadUserByLoginUseCase;
    private final UpdateUserUseCase updateUserUseCase;


    @Transactional
    @Override
    public void deleteExperienceFromUser(String userEmail, Long experienceId) {
        User user = loadUserByLoginUseCase.loadByLogin(userEmail);
        ProfessionalExperience experience = user.getResume()
                .getProfessionalExperiences()
                .stream()
                .filter(x -> x.getId().equals(experienceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Experience with id " + experienceId + " not found"));
        user.getResume().getProfessionalExperiences().remove(experience);
        updateUserUseCase.update(user);
    }
}
