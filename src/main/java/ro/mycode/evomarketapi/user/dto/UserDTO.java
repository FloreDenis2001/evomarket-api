package ro.mycode.evomarketapi.user.dto;

import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.system.security.UserRole;

import java.time.LocalDateTime;
import java.util.Set;

public record UserDTO(String firstName, String lastName, String phoneNumber, String email, String password, UserRole userRole, LocalDateTime registeredAt, LocalDateTime createdAt, boolean active, Set<Order> orderSet) {
}
