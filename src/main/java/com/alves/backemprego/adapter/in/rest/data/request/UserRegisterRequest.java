package com.alves.backemprego.adapter.in.rest.data.request;

public record UserRegisterRequest(
        String name,
        String phone,
        String email,
        String password
) {
}
