package com.alves.backemprego.application.domain.service.auth;

import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.port.in.auth.AuthUseCase;
import com.alves.backemprego.application.port.in.user.LoadUserByLoginUseCase;
import com.alves.backemprego.common.custonannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@UseCase
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final LoadUserByLoginUseCase loadUserByLoginUseCase;
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                return loadUserByLoginUseCase.loadByLogin(username);
            }
        }
        throw new RuntimeException("Usuário não autenticado");
    }
}
