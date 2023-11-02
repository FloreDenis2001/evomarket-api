package ro.mycode.evomarketapi.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
