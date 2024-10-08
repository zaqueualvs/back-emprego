package com.alves.backemprego.application.domain.service.user;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.enums.UserRole;
import com.alves.backemprego.application.port.in.user.SaveUserUseCase;
import com.alves.backemprego.application.port.out.user.SaveUserPort;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@UseCase
@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Transactional
    @Override
    public User save(User user) {
        user.setRole(UserRole.USER);
        user.setShow(Boolean.FALSE);
        LocalDate date = LocalDate.now();
        date = date.plusDays(7);
        user.setDisplayExpiration(date);
        user.setDisplay(Boolean.TRUE);
        return saveUserPort.save(user);
    }
}
