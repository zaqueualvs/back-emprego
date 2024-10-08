package com.alves.backemprego.application.domain.model;

import com.alves.backemprego.application.domain.model.enums.UserRole;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private Resume resume;
    private Set<Category> categories = new HashSet<>();
    private String password;
    private boolean show;
    private boolean display;
    private LocalDate displayExpiration;
    private UserRole role;
    private String photo;

    public User() {
    }

    public User(Long id,
                String name,
                String phone,
                String email,
                Resume resume,
                Set<Category> categories,
                String password,
                boolean show,
                boolean display,
                LocalDate displayExpiration,
                UserRole role,
                String photo) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.resume = resume;
        this.categories = categories;
        this.password = password;
        this.show = show;
        this.display = display;
        this.displayExpiration = displayExpiration;
        this.role = role;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean getDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public LocalDate getDisplayExpiration() {
        return displayExpiration;
    }

    public void setDisplayExpiration(LocalDate displayExpiration) {
        this.displayExpiration = displayExpiration;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
