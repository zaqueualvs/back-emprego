package com.alves.backemprego.application.port.out.education;

import com.alves.backemprego.application.domain.model.Education;

public interface DeleteEducationFromUserPort {

    void deleteEducationFromUser(Education education);
}
