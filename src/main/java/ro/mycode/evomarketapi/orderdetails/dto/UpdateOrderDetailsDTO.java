package ro.mycode.evomarketapi.orderdetails.dto;

import lombok.Builder;

@Builder
public record UpdateOrderDetailsDTO(
        int quantity,
        Long price
) {
}
