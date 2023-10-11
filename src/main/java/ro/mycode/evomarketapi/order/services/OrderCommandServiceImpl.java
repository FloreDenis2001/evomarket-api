package ro.mycode.evomarketapi.order.services;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.OrderAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.OrderNotFoundException;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;

import java.util.Optional;

@Service
@Transactional
public class OrderCommandServiceImpl implements OrderCommandService {

    OrderRepo orderRepo;


    public OrderCommandServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public void addOrder(OrderDTO orderDTO) {

        Order orderAdded = new Order();
        orderAdded.setUserId(orderDTO.userId());
        orderAdded.setOrderDetailsSet(orderDTO.orderDetailsSet());
        orderAdded.setOrderDate(orderDTO.orderDate());
        orderAdded.setOrderStatus(orderDTO.orderStatus());
        orderAdded.setOrderPhone(orderDTO.orderPhone());
        orderAdded.setOrderEmail(orderDTO.orderEmail());
        orderAdded.setOrderAddress(orderDTO.orderAddress());
        orderAdded.setShippingAddress(orderDTO.shippingAddress());
        orderAdded.setAmmount(orderDTO.ammount());

        orderRepo.saveAndFlush(orderAdded);
    }




}
