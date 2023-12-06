package ro.mycode.evomarketapi.user.dto;

import lombok.Builder;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.system.security.UserRole;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record UserDTO(String firstName, String lastName, String phoneNumber, String email, String password, boolean active, Set<Order> orderSet) {
}
