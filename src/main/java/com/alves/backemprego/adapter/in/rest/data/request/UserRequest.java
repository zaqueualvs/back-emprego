package com.alves.backemprego.adapter.in.rest.data.request;

import java.util.Set;


public record UserRequest(
        Long id,
        String name,
        String phone,
        String email,
        ResumeRequest resume,
        boolean show,
        Set<Long> categories,
        String photo
) {
}
