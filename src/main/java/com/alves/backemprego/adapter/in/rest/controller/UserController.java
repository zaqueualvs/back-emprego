package com.alves.backemprego.adapter.in.rest.controller;

import com.alves.backemprego.adapter.in.rest.data.request.UserRequest;
import com.alves.backemprego.adapter.in.rest.data.response.AcademicDegreeResponse;
import com.alves.backemprego.adapter.in.rest.data.response.StatusResponse;
import com.alves.backemprego.adapter.in.rest.data.response.UserResponse;
import com.alves.backemprego.adapter.in.rest.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.in.rest.mapper.UserRestMapper;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.enums.AcademicDegree;
import com.alves.backemprego.application.domain.model.enums.Status;
import com.alves.backemprego.application.port.in.auth.AuthUseCase;
import com.alves.backemprego.application.port.in.education.DeleteEducationFromUserUseCase;
import com.alves.backemprego.application.port.in.professionalexperience.DeleteExperienceFromUserUseCase;
import com.alves.backemprego.application.port.in.user.LoadUserByLoginUseCase;
import com.alves.backemprego.application.port.in.user.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRestMapper userRestMapper;
    private final LoadUserByLoginUseCase loadUserByLoginUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final AuthUseCase authUseCase;
    private final DeleteExperienceFromUserUseCase deleteExperienceFromUserUseCase;
    private final DeleteEducationFromUserUseCase deleteEducationFromUserUseCase;


    @GetMapping()
    public ResponseEntity<UserResponse> loadBylogin() {
        User user = authUseCase.getCurrentUser();
        UserResponse userResponse = userRestMapper.toResponse(user, new CycleAvoidingMappingContext());
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }


    @GetMapping("/enums/status")
    public ResponseEntity<List<StatusResponse>> getEnumsStatus() {
        List<StatusResponse> enums = Arrays.stream(Status.values())
                .map(status -> new StatusResponse(status.getCod(), status.getDescription()))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(enums);
    }

    @GetMapping("/enums/academicDegree")
    public ResponseEntity<List<AcademicDegreeResponse>> getEnumsAcademicDegree() {
        List<AcademicDegreeResponse> enums = Arrays.stream(AcademicDegree.values())
                .map(academic -> new AcademicDegreeResponse(academic.getCod(), academic.getDescription())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(enums);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable String email,
                                             @RequestBody UserRequest userRequest) {
        User user = loadUserByLoginUseCase.loadByLogin(email);
        userRestMapper.copyProperties(userRequest, user);
        updateUserUseCase.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{email}/education/{educationId}")
    public ResponseEntity<Object> deleteEducationFromUser(@PathVariable String email,
                                                          @PathVariable Long educationId) {

        deleteEducationFromUserUseCase.deleteEducationFromUser(email, educationId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{email}/experience/{experienceId}")
    public ResponseEntity<Object> deleteExperienceFromUser(@PathVariable String email,
                                                           @PathVariable Long experienceId) {
        deleteExperienceFromUserUseCase.deleteExperienceFromUser(email, experienceId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
