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
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;


    @BeforeEach
    void setUp() {
        orderRepo.deleteAll();
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

        assertEquals(true,orderRepo.findById(order.getId()).get().getOrderStatus().equals("Pending"));
    }

    @Test
    void findAllByUserId() {

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
        Order order1 = Order.builder()
                .ammount(300L)
                .userId(user.getId())
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("denis@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();
        orderRepo.saveAndFlush(order);



        assertEquals(true,orderRepo.findAllByUserId(user.getId()).get().size()==1);

    }
}