package ro.mycode.evomarketapi.product.services;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;

@Service
@Transactional
public interface ProductCommandService {
    void addProduct(ProductDTO productDTO);
    void updateProduct(String SKU, UpdateProductRequest updateProductRequest);
    void deleteProduct(String SKU);
}
