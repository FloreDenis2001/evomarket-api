package ro.mycode.evomarketapi.orderdetails.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.OrderDetailsNotFoundException;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.dto.UpdateOrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;

import java.util.Optional;

@Service
public class OrderDetailsCommandServiceImpl implements OrderDetailsCommandService {

    private OrderDetailsRepo orderDetailsRepository;

    public OrderDetailsCommandServiceImpl(OrderDetailsRepo orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public void addOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findByOrderIdAndProductIdAndSKU(
                orderDetailsDTO.order().getId(),
                orderDetailsDTO.product().getId(),
                orderDetailsDTO.SKU()
        );


        if (orderDetailsOptional.isPresent()) {
            throw new RuntimeException("OrderDetails already exists");
        } else {
            OrderDetails orderDetails = new OrderDetails(
                    orderDetailsDTO.order(),
                    orderDetailsDTO.product(),
                    orderDetailsDTO.quantity(),
                    orderDetailsDTO.price(),
                    orderDetailsDTO.SKU()
            );
            orderDetailsRepository.save(orderDetails);
        }
    }

    @Override
    public void updateOrderDetails(OrderDetailsDTO orderDetailsDTO, UpdateOrderDetailsDTO updateOrderDetailsDTO) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findByOrderIdAndProductIdAndSKU(
                orderDetailsDTO.order().getId(),
                orderDetailsDTO.product().getId(),
                orderDetailsDTO.SKU()
        );
        if (orderDetailsOptional.isPresent()) {
            OrderDetails orderDetails = orderDetailsOptional.get();

            if (updateOrderDetailsDTO.quantity() != 0)
                orderDetails.setQuantity(updateOrderDetailsDTO.quantity());

            if (updateOrderDetailsDTO.price() != 0)
                orderDetails.setPrice(updateOrderDetailsDTO.price());

            orderDetailsRepository.save(orderDetails);
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public void deleteOrderDetails(OrderDetailsDTO orderDetailsDTO) {

        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findByOrderIdAndProductIdAndSKU(
                orderDetailsDTO.order().getId(),
                orderDetailsDTO.product().getId(),
                orderDetailsDTO.SKU()
        );
        if (orderDetailsOptional.isPresent()) {
            orderDetailsRepository.delete(orderDetailsOptional.get());
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }


}
