package ro.mycode.evomarketapi.order.dto;

import lombok.*;
import ro.mycode.evomarketapi.address.Address;
import ro.mycode.evomarketapi.product.dto.ProductBagDTO;
import ro.mycode.evomarketapi.product.dto.ProductDTO;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateOrderRequest {

    private List<ProductBagDTO> products;
    private Long userId;
    private Address shippingAddress;
    private Address orderAddress;



    public List<ProductBagDTO> getProducts() {
        return products;
    }

    public Long getUserId() {
        return userId;
    }


    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getOrderAddress() {
        return orderAddress;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "products=" + products +
                ", userId=" + userId +
                ", shippingAddress=" + shippingAddress +
                ", orderAddress=" + orderAddress +
                '}';
    }
}
