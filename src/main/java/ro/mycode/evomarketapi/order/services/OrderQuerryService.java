package ro.mycode.evomarketapi.order.services;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.order.models.Order;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface OrderQuerryService {

    Optional<Order> findById(Long id);

    Optional<List<Order>> findAllByUserId(Long userId);

}
