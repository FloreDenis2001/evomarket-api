package ro.mycode.evomarketapi.product.dto;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record ProductDTO(
        String name,
        String description,
        Long price,
        String SKU,

        int quantity,

        double weight,

        String category,

        double rating,

        LocalDateTime createdDate) {
}
