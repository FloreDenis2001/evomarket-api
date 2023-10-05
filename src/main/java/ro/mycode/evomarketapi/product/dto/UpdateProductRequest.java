package ro.mycode.evomarketapi.product.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UpdateProductRequest(
        String name,
        String description,
        Long price,

        int quantity,

        double weight,

        String category,


        LocalDateTime createdDate) {
}
