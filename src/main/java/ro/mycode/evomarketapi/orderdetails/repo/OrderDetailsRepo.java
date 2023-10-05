package ro.mycode.evomarketapi.orderdetails.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

    Optional<OrderDetails> findById(long id);


    Optional<OrderDetails> findBySKU(String SKU);

    Optional<OrderDetails>  findByOrderIdAndProductId(long orderId, long productId);


    Optional<OrderDetails>  findByOrderIdAndSKU(long orderId, String SKU);

    Optional<OrderDetails>  findByOrderId(long orderId);

    Optional<OrderDetails>  findByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU);


    @EntityGraph(attributePaths = {"product"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<List<OrderDetails>> getAllById(long id);


    Optional<List<OrderDetails>> getAllBySKU(String SKU);

    Optional<List<OrderDetails>>  getAllByOrderIdAndProductId(long orderId, long productId);

    Optional<List<OrderDetails>>  getAllByOrderIdAndSKU(long orderId, String SKU);

    Optional<List<OrderDetails>>  getAllByOrderId(long orderId);

    Optional<List<OrderDetails>>  getAllByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU);

    Optional<List<OrderDetails>> getAllByOrderIdAndProductIdAndSKUAndProduct(long orderId, long productId, String SKU, Product product);

}
