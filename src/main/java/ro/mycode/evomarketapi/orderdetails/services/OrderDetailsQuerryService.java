package ro.mycode.evomarketapi.orderdetails.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public interface OrderDetailsQuerryService {
    Optional<OrderDetails> findById(long id);






    Optional<OrderDetails> findByOrderId(long orderId);

}
