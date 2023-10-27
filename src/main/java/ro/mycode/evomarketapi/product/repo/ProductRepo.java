package ro.mycode.evomarketapi.product.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Product> getProductBySKU(String SKU);

    Optional<List<Product>> getProductsByCategory(String category);



    Optional<List<Product>> getProductsByPriceBetween(Long min, Long max);

    Optional<List<Product>>  getProductsByPriceLessThan(Long max);

    Optional<List<Product>>  getProductsByPriceGreaterThan(Long min);

    Optional<List<Product>>  getProductsByPriceLessThanAndCategory(Long max, String category);

    Optional<List<Product>>  getProductsByPriceGreaterThanAndCategory(Long min, String category);

    Optional<List<Product>> getProductsByPriceBetweenAndCategory(Long min, Long max, String category);

    Optional<List<Product>> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name);

    Optional<List<Product>> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name);

    Optional<List<Product>>  getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name);

    Optional<List<Product>> getProductsByPriceLessThanAndName(Long max, String name);

    Optional<List<Product>>  getProductsByPriceGreaterThanAndName(Long min, String name);

    Optional<List<Product>>getProductsByPriceBetweenAndName(Long min, Long max, String name);


}
