package com.alves.backemprego.application.port.in.education;

public interface DeleteEducationFromUserUseCase {

    void deleteEducationFromUser(String userEmail, Long educationId);
}
