package ro.mycode.evomarketapi.product.intercom.query;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;

@FeignClient(name = "product-query-service", url = "http://localhost:8080/api/v1/products")
public interface QueryProduct {
    @GetMapping("/all")
    
    ResponseEntity<List<Product>> getAllProducts();

    @GetMapping("/id/{id}")
    ResponseEntity<Product> getProductById(Long id);

    @GetMapping("/sku/{sku}")
    ResponseEntity<Product> getProductBySKU(String sku);

    @GetMapping("/category/{category}")
    ResponseEntity<List<Product>> getProductsByCategory(String category);


    @GetMapping("/price/between/{min}/{max}")
    ResponseEntity<List<Product>> getProductsByPriceBetween(Long min, Long max);

    @GetMapping("/price/less/{max}")
    ResponseEntity<List<Product>> getProductsByPriceLessThan(Long max);

    @GetMapping("/price/greater/{min}")
    ResponseEntity<List<Product>> getProductsByPriceGreaterThan(Long min);

    @GetMapping("/price/less/{max}/category/{category}")
    ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategory(Long max, String category);

    @GetMapping("/price/greater/{min}/category/{category}")
    ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategory(Long min, String category);

    @GetMapping("/price/between/{min}/{max}/category/{category}")
    ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategory(Long min, Long max, String category);

    @GetMapping("/price/less/{max}/category/{category}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name);

    @GetMapping("/price/greater/{min}/category/{category}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name);

    @GetMapping("/price/between/{min}/{max}/category/{category}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name);

    @GetMapping("/price/less/{max}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceLessThanAndName(Long max, String name);

    @GetMapping("/price/greater/{min}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndName(Long min, String name);

    @GetMapping("/price/between/{min}/{max}/name/{name}")
    ResponseEntity<List<Product>> getProductsByPriceBetweenAndName(Long min, Long max, String name);



}
