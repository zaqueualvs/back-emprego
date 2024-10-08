package com.alves.backemprego.application.domain.model.enums;

public enum UserRole {

    USER(1),
    ADMIN(2);

    private Integer cod;

    UserRole(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static UserRole getUserRole(Integer role) {
        if (role == null) {
            return null;
        }
        for (UserRole userRole : values()) {
            if (userRole.cod.equals(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid role");
    }
}
