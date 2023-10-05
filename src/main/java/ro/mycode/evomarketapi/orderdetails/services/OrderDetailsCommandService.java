package ro.mycode.evomarketapi.orderdetails.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.dto.UpdateOrderDetailsDTO;

@Service
@Transactional
public interface OrderDetailsCommandService {

    void addOrderDetails(OrderDetailsDTO orderDetailsDTO);

    void updateOrderDetails(Long idOrderDetails, UpdateOrderDetailsDTO updateOrderDetailsDTO);
//    void deleteOrderDetails();


}
