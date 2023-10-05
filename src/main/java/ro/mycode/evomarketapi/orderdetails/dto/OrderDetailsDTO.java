package ro.mycode.evomarketapi.orderdetails.dto;

import lombok.Builder;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.product.models.Product;

@Builder
public record OrderDetailsDTO(
        Order order,
        Product product,
        int quantity,
        double price,
        String SKU
        
) {
}
