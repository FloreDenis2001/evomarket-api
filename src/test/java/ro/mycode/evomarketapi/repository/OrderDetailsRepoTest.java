package ro.mycode.evomarketapi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
class OrderDetailsRepoTest {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        orderDetailsRepo.deleteAll();

        orderRepo.deleteAll();

        productRepo.deleteAll();

        userRepo.deleteAll();
    }


    @Test
    void findById() {

        User user = new User();
        user.setFirstName("Andrei");
        user.setLastName("Popescu");
        user.setEmail("andreipopescu@yahoo.com");
        user.setPassword("andrei1234");
        user.setPhoneNumber("0722222222");
        user.setUserRole(UserRole.ADMIN);
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);

        userRepo.saveAndFlush(user);

        Order order = Order.builder()
                .ammount(100L)
                .userId(user.getId())
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();
        orderRepo.saveAndFlush(order);

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);

        OrderDetails orderDetails = OrderDetails.builder()
                .order(order)
                .product(product1)
                .quantity(1)
                .price(100L)
                .SKU("SKU17887416")
                .build();

        orderDetailsRepo.saveAndFlush(orderDetails);

        assertEquals(100, orderDetailsRepo.findById(orderDetails.getId()).get().getPrice());
    }


    @Test
    void findByOrderId() {

        User user = new User();
        user.setFirstName("Andrei");
        user.setLastName("Popescu");
        user.setEmail("andreipopescu@yahoo.com");
        user.setPassword("andrei1234");
        user.setPhoneNumber("0722222222");
        user.setUserRole(UserRole.ADMIN);
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);

        userRepo.saveAndFlush(user);

        Order order = Order.builder()
                .ammount(100L)
                .userId(user.getId())
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();
        orderRepo.saveAndFlush(order);

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);

        OrderDetails orderDetails = OrderDetails.builder()
                .order(order)
                .product(product1)
                .quantity(1)
                .price(100L)
                .SKU("SKU17887416")
                .build();

        orderDetailsRepo.saveAndFlush(orderDetails);

        assertEquals(1, orderDetailsRepo.findByOrderId(orderDetails.getOrder().getId()).get().getQuantity());
    }









}

