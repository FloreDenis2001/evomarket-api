package ro.mycode.evomarketapi.product.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Product> getProductsById(Long id);

    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT p FROM Product p")
    List<Product> getAllProducts();

    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Product> getProductBySKU(String SKU);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByCategory(String category);


    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByPriceBetween(Long min, Long max);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceLessThan(Long max);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceGreaterThan(Long min);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceLessThanAndCategory(Long max, String category);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceGreaterThanAndCategory(Long min, String category);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByPriceBetweenAndCategory(Long min, Long max, String category);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>> getProductsByPriceLessThanAndName(Long max, String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>  getProductsByPriceGreaterThanAndName(Long min, String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<Product>>getProductsByPriceBetweenAndName(Long min, Long max, String name);


}
