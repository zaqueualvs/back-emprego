package com.alves.backemprego.adapter.in.rest.data.response;

import java.util.Set;


public record PublicUserResponse(
        Long id,
        String name,
        String phone,
        String email,
        ResumeResponse resume,
        Set<CategoryResponse> categories,
        String photo) {
}
