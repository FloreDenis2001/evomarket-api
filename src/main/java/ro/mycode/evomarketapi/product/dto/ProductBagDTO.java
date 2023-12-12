package ro.mycode.evomarketapi.product.dto;

public class ProductBagDTO {

    private ProductDTO product;
    private int quantity;

    public ProductBagDTO(ProductDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

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
