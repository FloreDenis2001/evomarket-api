package ro.mycode.evomarketapi.user.dto;

import lombok.*;
import ro.mycode.evomarketapi.system.security.UserRole;


@Builder
public record LoginResponse(Long id, String email, String token, String firstName, String lastName, UserRole userRole) {
}
