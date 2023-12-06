package ro.mycode.evomarketapi.product.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;

@Service
public interface ProductQuerryService {


    List<ProductDTO> getAllProducts();

    Product findById(Long id);

    Product getProductBySKU(String SKU);

    List<Product> getProductsByCategory(String category);


    List<Product> getProductsByPriceBetween(Long min, Long max);

    List<Product> getProductsByPriceLessThan(Long max);

    List<Product> getProductsByPriceGreaterThan(Long min);

    List<Product> getProductsByPriceLessThanAndCategory(Long max, String category);

    List<Product> getProductsByPriceGreaterThanAndCategory(Long min, String category);

    List<Product> getProductsByPriceBetweenAndCategory(Long min, Long max, String category);


}
