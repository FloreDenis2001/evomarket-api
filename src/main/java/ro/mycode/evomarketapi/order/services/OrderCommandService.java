package ro.mycode.evomarketapi.order.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.order.dto.OrderDTO;

@Service
@Transactional
public interface OrderCommandService {

    void addOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void deleteOrder(long id);
}
