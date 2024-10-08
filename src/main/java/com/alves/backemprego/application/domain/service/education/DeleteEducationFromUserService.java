package com.alves.backemprego.application.domain.service.education;

import com.alves.backemprego.application.domain.model.Education;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.education.DeleteEducationFromUserUseCase;
import com.alves.backemprego.application.port.in.user.LoadUserByLoginUseCase;
import com.alves.backemprego.application.port.in.user.UpdateUserUseCase;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class DeleteEducationFromUserService implements DeleteEducationFromUserUseCase {

    private final LoadUserByLoginUseCase loadUserByLoginUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @Transactional
    @Override
    public void deleteEducationFromUser(String userEmail, Long educationId) {
        User user = loadUserByLoginUseCase.loadByLogin(userEmail);
        Education education = user.getResume()
                .getEducations()
                .stream()
                .filter(x -> x.getId().equals(educationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Education with id " + educationId + " not found"));
        user.getResume().getEducations().remove(education);
        updateUserUseCase.update(user);
    }
}
