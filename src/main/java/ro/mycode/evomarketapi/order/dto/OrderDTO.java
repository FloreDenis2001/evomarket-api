package ro.mycode.evomarketapi.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record OrderDTO(Long id, Long ammount, String shippingAddress, String orderAddress, String orderEmail, String orderPhone, LocalDateTime orderDate, String orderStatus, Set<OrderDetails> orderDetailsSet) {
}
