package ro.mycode.evomarketapi.product.dto;


import lombok.*;

@Builder
@Data
@Getter
@NoArgsConstructor

@AllArgsConstructor
public class ProductBagDTO {

    private ProductDTO product;
    private int quantity;



    public ProductDTO getProduct() {
        return product;
    }



    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ProductBagDTO{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }



}
