package ro.mycode.evomarketapi.orderdetails.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    OrderDetails findById(long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    OrderDetails findBySKU(String SKU);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    OrderDetails findByOrderIdAndProductId(long orderId, long productId);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    OrderDetails findByOrderIdAndSKU(long orderId, String SKU);




}
