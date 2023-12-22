package ro.mycode.evomarketapi.order.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import ro.mycode.evomarketapi.address.Address;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record OrderDTO(Long id, Long userId, Long ammount, Address shippingAddress, Address orderAddress, String orderEmail, String orderPhone, String orderStatus, Set<OrderDetails> orderDetailsSet) {
}
