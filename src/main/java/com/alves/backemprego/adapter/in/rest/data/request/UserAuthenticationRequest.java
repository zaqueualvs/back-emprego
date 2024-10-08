package com.alves.backemprego.adapter.in.rest.data.request;

public record UserAuthenticationRequest(
        String email,
        String password) {
}
