package com.alves.backemprego.application.domain.model;

import java.util.ArrayList;
import java.util.List;

public class UserPage {
    private List<User> users = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;

    public UserPage() {
    }

    public UserPage(List<User> users, Long totalElements, Integer totalPages) {
        this.users = users;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
