package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.user.UpdateUserUseCase;
import com.alves.backemprego.application.port.out.user.SaveUserPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final SaveUserPort saveUserPort;

    @Transactional
    @Override
    public User update(User user) {
        if (user.getResume() != null) {
            if (user.getResume().getUser() == null) {
                user.getResume().setUser(user);
            }
            user.getResume().getEducations().forEach(education -> {
                if (education.getResume() == null) {
                    education.setResume(user.getResume());
                }
            });
            user.getResume().getProfessionalExperiences().forEach(experience -> {
                if (experience.getResume() == null) {
                    experience.setResume(user.getResume());
                }
            });
        }
        return saveUserPort.save(user);
    }
}
