package com.alves.backemprego.application.port.in.professionalexperience;

public interface DeleteExperienceFromUserUseCase {

    void deleteExperienceFromUser(String userEmail, Long experienceId);
}
