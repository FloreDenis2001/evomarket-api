package ro.mycode.evomarketapi.product.services;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface ProductCommandService {
    void addProduct(String name, String description, Long price, String SKU, String image);
    void updateProduct(Long id, String name, String description, Long price, String SKU, String image);
    void deleteProduct(Long id,String SKU);


}
