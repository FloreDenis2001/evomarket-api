package ro.mycode.evomarketapi.system.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    public String getRole() {
        return role;
    }
}
