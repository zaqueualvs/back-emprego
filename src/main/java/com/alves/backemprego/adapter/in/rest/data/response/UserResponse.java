package com.alves.backemprego.adapter.in.rest.data.response;

import java.time.LocalDate;
import java.util.Set;


public record UserResponse(
        Long id,
        String name,
        String phone,
        String email,
        ResumeResponse resume,
        Boolean show,
        Set<CategoryResponse> categories,
        LocalDate displayExpiration,
        String photo
) {
}
