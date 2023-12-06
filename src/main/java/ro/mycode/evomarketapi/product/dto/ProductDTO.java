package ro.mycode.evomarketapi.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.mycode.evomarketapi.product.models.Product;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private String name;

    private String description;

    private Long price;

    private String SKU;

    private int quantity;

    private double weight;

    private String category;

    private double rating;

    public static ProductDTO fromProduct(Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .SKU(product.getSku())
                .quantity(product.getQuantity())
                .weight(product.getWeight())
                .category(product.getCategory())
                .rating(product.getRating())
                .build();
    }

}
