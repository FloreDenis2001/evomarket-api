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


    Optional<OrderDetails> findBySKU(String SKU);

    Optional<OrderDetails> findByOrderIdAndProductId(long orderId, long productId);


    Optional<OrderDetails> findByOrderIdAndSKU(long orderId, String SKU);

    Optional<OrderDetails> findByOrderId(long orderId);

    Optional<OrderDetails> findByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU);


    Optional<List<OrderDetails>> getAllById(long id);


    Optional<List<OrderDetails>> getAllBySKU(String SKU);

    Optional<List<OrderDetails>> getAllByOrderIdAndProductId(long orderId, long productId);

    Optional<List<OrderDetails>> getAllByOrderIdAndSKU(long orderId, String SKU);

    Optional<List<OrderDetails>> getAllByOrderId(long orderId);

    Optional<List<OrderDetails>> getAllByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU);

    Optional<List<OrderDetails>> getAllByOrderIdAndProductIdAndSKUAndProduct(long orderId, long productId, String SKU, Product product);
}
