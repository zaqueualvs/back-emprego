package com.alves.backemprego.adapter.in.rest.controller;

import com.alves.backemprego.adapter.in.rest.data.request.UserAuthenticationRequest;
import com.alves.backemprego.adapter.in.rest.data.request.UserRegisterRequest;
import com.alves.backemprego.adapter.in.rest.data.response.UserLoginResponse;
import com.alves.backemprego.adapter.in.rest.mapper.UserRestMapper;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.UserAuthentication;
import com.alves.backemprego.application.port.in.auth.AuthenticateUserUseCase;
import com.alves.backemprego.application.port.in.user.SaveUserUseCase;
import com.alves.backemprego.infrastructure.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticateUserUseCase authenticateUserUseCase;
    private final SaveUserUseCase saveUserUseCase;
    private final UserRestMapper userRestMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserAuthenticationRequest request) {
        UserAuthentication user = authenticateUserUseCase.authenticate(request.email());
        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            var token = tokenService.generateToken(user);
            return ResponseEntity.status(HttpStatus.OK).body(new UserLoginResponse(token));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRegisterRequest request) {
        if (authenticateUserUseCase.authenticate(request.email()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User user = userRestMapper.toModel(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        saveUserUseCase.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
