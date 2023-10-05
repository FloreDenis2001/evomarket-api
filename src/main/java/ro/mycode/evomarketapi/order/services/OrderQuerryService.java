package ro.mycode.evomarketapi.order.services;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.order.models.Order;

import java.util.Optional;

@Service
@Transactional
public interface OrderQuerryService {

        Optional<Order> findById(Long id);

        Optional<Order> findByUserId(Long userId);

        Optional<Order> findByUserIdAndStatus(Long userId, String status);

        Optional<Order> findByStatus(String status);
}
