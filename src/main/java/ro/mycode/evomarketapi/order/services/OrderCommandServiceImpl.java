package ro.mycode.evomarketapi.order.services;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.OrderAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.OrderNotFoundException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.exceptions.UserNotFound;
import ro.mycode.evomarketapi.order.dto.CreateOrderRequest;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;
import ro.mycode.evomarketapi.utils.Mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderCommandServiceImpl implements OrderCommandService {

    OrderRepo orderRepo;
    UserRepo userRepo;

    ProductRepo productRepo;

    OrderDetailsRepo orderDetailsRepo;


    public OrderCommandServiceImpl(OrderRepo orderRepo, UserRepo userRepo, OrderDetailsRepo orderDetailsRepo,ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.orderDetailsRepo = orderDetailsRepo;
    }

    @Override
    @Transactional
    public void addOrder(CreateOrderRequest createOrderRequest) {

        User user = getUserForOrder(createOrderRequest);

        Order order = createOrderForUser(user, createOrderRequest);

        orderRepo.saveAndFlush(order);
        createAllOrderDetailsForOrder(order, createOrderRequest);
    }

    private void createAllOrderDetailsForOrder(Order order, CreateOrderRequest createOrderRequest) {
        if (createOrderRequest.getProducts().isEmpty()) {
            throw new ProductNotFoundException();
        } else {
            List<OrderDetails> list = new ArrayList<>();
            createOrderRequest.getProducts().forEach(productBagDTO -> {

                Product product = productRepo.getProductBySku(productBagDTO.getProduct().getSKU()).get();
                OrderDetails orderDetails = OrderDetails.builder()
                        .order(order)
                        .product(product)
                        .quantity(productBagDTO.getQuantity())
                        .price(productBagDTO.getProduct().getPrice() * productBagDTO.getQuantity())
                        .SKU(productBagDTO.getProduct().getSKU())
                        .build();
                list.add(orderDetails);
            });

            orderDetailsRepo.saveAllAndFlush(list);
        }
    }

    private Order createOrderForUser(User user, CreateOrderRequest createOrderRequest) {
        Order order = Order.builder()
                .userId(user.getId())
                .orderDate(LocalDateTime.now())
                .orderStatus("pending")
                .orderEmail(user.getEmail())
                .orderPhone("0740123456")
                .orderAddress(createOrderRequest.getOrderAddress())
                .shippingAddress(createOrderRequest.getShippingAddress())
                .ammount(createOrderRequest.getProducts().stream().mapToLong(productBagDTO -> productBagDTO.getProduct().getPrice() * productBagDTO.getQuantity()).sum())
                .build();

        return order;

    }

    private User getUserForOrder(CreateOrderRequest createOrderRequest) {
        User user = userRepo.findById(createOrderRequest.getUserId()).get();
        if (user != null) {
            return user;
        } else {
            throw new UserNotFound();
        }
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Optional<Order> orderOptional = orderRepo.findById(orderDTO.id());
        if (orderOptional.isPresent()) {
            Order orderUpdated = orderOptional.get();
            orderUpdated.setUserId(orderDTO.userId());
            orderUpdated.setOrderDetailsSet(orderDTO.orderDetailsSet());
            orderUpdated.setOrderDate(LocalDateTime.now());
            orderUpdated.setOrderStatus(orderDTO.orderStatus());
            orderUpdated.setOrderPhone(orderDTO.orderPhone());
            orderUpdated.setOrderEmail(orderDTO.orderEmail());
            orderUpdated.setAmmount(orderDTO.ammount());
            orderRepo.saveAndFlush(orderUpdated);
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public void deleteOrder(long id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            orderRepo.delete(orderOptional.get());
        } else {
            throw new OrderNotFoundException();
        }
    }


}
