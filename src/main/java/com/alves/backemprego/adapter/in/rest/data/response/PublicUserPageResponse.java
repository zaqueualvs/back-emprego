package com.alves.backemprego.adapter.in.rest.data.response;

import java.util.List;

public record PublicUserPageResponse(
        List<PublicUserResponse> users,
        Long totalElements,
        Integer totalPages) {

}
