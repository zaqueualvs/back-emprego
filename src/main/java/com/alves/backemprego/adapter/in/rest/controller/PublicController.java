package com.alves.backemprego.adapter.in.rest.controller;

import com.alves.backemprego.adapter.in.rest.data.response.CategoryResponse;
import com.alves.backemprego.adapter.in.rest.data.response.PublicUserPageResponse;
import com.alves.backemprego.adapter.in.rest.data.response.PublicUserResponse;
import com.alves.backemprego.adapter.in.rest.mapper.CategoryRestMapper;
import com.alves.backemprego.adapter.in.rest.mapper.CycleAvoidingMappingContext;
import com.alves.backemprego.adapter.in.rest.mapper.PublicUserRestMapper;
import com.alves.backemprego.application.domain.model.User;
import com.alves.backemprego.application.domain.model.UserPage;
import com.alves.backemprego.application.port.in.category.FindAllCategoryUseCase;
import com.alves.backemprego.application.port.in.user.FindAllUserPageableUseCase;
import com.alves.backemprego.application.port.in.user.FindUserByCategoryUseCase;
import com.alves.backemprego.application.port.in.user.FindUserByIdUseCase;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/public")
@RestController
@RequiredArgsConstructor
public class PublicController {

    private final FindAllUserPageableUseCase findAllUserPageableUseCase;
    private final FindUserByCategoryUseCase findUserByCategoryUseCase;
    private final FindAllCategoryUseCase findAllCategoryUseCase;
    private final PublicUserRestMapper publicUserRestMapper;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final CategoryRestMapper categoryRestMapper;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> findAllCategories() {
        List<CategoryResponse> categoryResponses = findAllCategoryUseCase.findAllCategory()
                .stream()
                .map(categoryRestMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponses);
    }

    @GetMapping("/users")
    public ResponseEntity<PublicUserPageResponse> findAll(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "8") @PositiveOrZero Integer pageSize
    ) {
        UserPage userPage = findAllUserPageableUseCase
                .findAllUser(page, pageSize);
        List<PublicUserResponse> publicUserResponse = userPage.getUsers()
                .stream()
                .map(user -> publicUserRestMapper.toResponse(user, new CycleAvoidingMappingContext()))
                .toList();

        PublicUserPageResponse publicUserPageResponse = new PublicUserPageResponse(
                publicUserResponse,
                userPage.getTotalElements(),
                userPage.getTotalPages());
        return ResponseEntity.status(HttpStatus.OK).body(publicUserPageResponse);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<PublicUserResponse> findById(@PathVariable Long userId) {
        User user = findUserByIdUseCase.findById(userId);
        PublicUserResponse publicUserResponse = publicUserRestMapper.toResponse(user, new CycleAvoidingMappingContext());
        return ResponseEntity.status(HttpStatus.OK).body(publicUserResponse);
    }

    @GetMapping("/users/category/{categoryId}")
    public ResponseEntity<PublicUserPageResponse> findByCategory(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "5") @PositiveOrZero Integer pageSize) {

        UserPage userPage = findUserByCategoryUseCase
                .findByCategory(categoryId, page, pageSize);
        List<PublicUserResponse> publicUserResponse = userPage.getUsers()
                .stream()
                .map(user -> publicUserRestMapper.toResponse(user, new CycleAvoidingMappingContext()))
                .toList();

        PublicUserPageResponse publicUserPageResponse = new PublicUserPageResponse(publicUserResponse, userPage.getTotalElements(), userPage.getTotalPages());

        return ResponseEntity.status(HttpStatus.OK).body(publicUserPageResponse);
    }
}
