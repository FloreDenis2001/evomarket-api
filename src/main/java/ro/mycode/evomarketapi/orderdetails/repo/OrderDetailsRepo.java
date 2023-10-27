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



    Optional<OrderDetails>  findByOrderId(long orderId);




}
