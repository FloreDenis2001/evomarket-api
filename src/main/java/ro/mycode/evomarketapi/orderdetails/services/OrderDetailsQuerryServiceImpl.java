package ro.mycode.evomarketapi.orderdetails.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.exceptions.OrderDetailsNotFoundException;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;


@Service
public class OrderDetailsQuerryServiceImpl implements OrderDetailsQuerryService{
    private OrderDetailsRepo orderDetailsRepo;

    public OrderDetailsQuerryServiceImpl(OrderDetailsRepo orderDetailsRepo) {
        this.orderDetailsRepo = orderDetailsRepo;
    }


    @Override
    public Optional<OrderDetails> findById(long id) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findById(id);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> findBySKU(String SKU) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.findBySKU(SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }





    @Override
    public Optional<OrderDetails> findByOrderId(long orderId) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findByOrderId(orderId);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }





}
