package com.alves.backemprego.application.domain.service;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.out.user.FindAllUserPort;
import com.alves.backemprego.application.port.out.user.SaveUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledTasks {

    private final FindAllUserPort findAllUserPort;
    private final SaveUserPort saveUserPort;

    @Scheduled(cron = "0 0 23 * * *")
    public void verficarDataExpiracao() {
        List<User> userList = findAllUserPort.findAllUser();

        LocalDate now = LocalDate.now();

        for (User user : userList) {
            if (user.getDisplayExpiration().isBefore(now)) {
                user.setDisplay(Boolean.FALSE);
                saveUserPort.save(user);
            } else if (user.getDisplayExpiration().isAfter(now) && !user.getDisplay()) {
                user.setDisplay(Boolean.TRUE);
                saveUserPort.save(user);
            }
        }
    }

}
