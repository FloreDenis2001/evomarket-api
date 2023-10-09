package ro.mycode.evomarketapi.order.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.OrderNotFoundException;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;

import java.util.List;
import java.util.Optional;


@Service
public class OrderQuerryServiceImpl implements OrderQuerryService{

    OrderRepo orderRepo;

    public OrderQuerryServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    @Override
    public Optional<Order> findById(Long id) {
        Optional<Order> orderOptional =orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            return orderOptional;
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public Optional<List<Order>> findAllByUserId(Long userId) {
        Optional<List<Order>> orders=orderRepo.findAllByUserId(userId);
        if (orders.isPresent()) {
            return orders;
        } else {
            throw new OrderNotFoundException();
        }
    }

}
