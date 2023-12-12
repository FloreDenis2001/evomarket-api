package ro.mycode.evomarketapi.order.dto;

import ro.mycode.evomarketapi.product.dto.ProductBagDTO;
import ro.mycode.evomarketapi.product.dto.ProductDTO;

import java.util.List;

public class CreateOrderRequest {

    private List<ProductBagDTO> products;
    private String email;




    public CreateOrderRequest(List<ProductBagDTO> products , String email) {
        this.email= email;
        this.products = products;
    }

    public List<ProductBagDTO> getProducts() {
        return products;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "products=" + products +
                ", E" +
                "email=" + email +
                '}';
    }
}
