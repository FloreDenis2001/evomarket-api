package ro.mycode.evomarketapi.order.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.OrderAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.OrderNotFoundException;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;

import java.util.Optional;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    OrderRepo orderRepo;


    public OrderCommandServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        Optional<Order> order = orderRepo.findById(orderDTO.id());

        if (order.isPresent()) {
            throw new OrderAlreadyExistException();
        } else {
            Order orderAdded = new Order();
            orderAdded.setId(orderDTO.id());
//            orderAdded.setUserId(orderDTO.userId());
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

    @Override
    public void deleteOrder(Long id) {

        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {
            orderRepo.deleteById(id);
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
Optional<Order> order=orderRepo.findById(orderDTO.id());
if (order.isPresent()) {
    Order orderUpdated = new Order();
    orderUpdated.setId(orderDTO.id());
//    orderUpdated.setUserId(orderDTO.userId());
    orderUpdated.setOrderDetailsSet(orderDTO.orderDetailsSet());
    orderUpdated.setOrderDate(orderDTO.orderDate());
    orderUpdated.setOrderStatus(orderDTO.orderStatus());
    orderUpdated.setOrderPhone(orderDTO.orderPhone());
    orderUpdated.setOrderEmail(orderDTO.orderEmail());
    orderUpdated.setOrderAddress(orderDTO.orderAddress());
    orderUpdated.setShippingAddress(orderDTO.shippingAddress());
    orderUpdated.setAmmount(orderDTO.ammount());

    orderRepo.saveAndFlush(orderUpdated);
} else {
    throw new OrderNotFoundException();
}
    }
}