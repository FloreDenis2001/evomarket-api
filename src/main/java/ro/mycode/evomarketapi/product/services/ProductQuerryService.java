package ro.mycode.evomarketapi.product.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;

@Service
public interface ProductQuerryService {


    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product getProductBySKU(String SKU);
    List<Product> getProductsByCategory(String category);


    List<Product> getProductsByPriceBetween(Long min, Long max);

    List<Product> getProductsByPriceLessThan(Long max);

    List<Product> getProductsByPriceGreaterThan(Long min);

    List<Product> getProductsByPriceLessThanAndCategory(Long max, String category);

    List<Product> getProductsByPriceGreaterThanAndCategory(Long min, String category);

    List<Product> getProductsByPriceBetweenAndCategory(Long min, Long max, String category);

    List<Product> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name);

    List<Product> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name);


    List<Product> getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name);

    List<Product> getProductsByPriceLessThanAndName(Long max, String name);

    List<Product> getProductsByPriceGreaterThanAndName(Long min, String name);

    List<Product> getProductsByPriceBetweenAndName(Long min, Long max, String name);






}
