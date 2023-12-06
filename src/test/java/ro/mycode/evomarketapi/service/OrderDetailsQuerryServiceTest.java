package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.OrderDetailsNotFoundException;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryServiceImpl;
import ro.mycode.evomarketapi.product.models.Product;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class OrderDetailsQuerryServiceTest {

    @Mock
    private OrderDetailsRepo orderDetailsRepo;

    @InjectMocks
    private OrderDetailsQuerryServiceImpl orderDetailsQuerryServiceImpl;

    @Test
    void findById() {
        Order order = Order.builder()
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetails orderDetails1 = OrderDetails.builder().order(order).product(product1).price(100L).quantity(1).SKU(product1.getSku()).build();
        doReturn(Optional.of(orderDetails1)).when(orderDetailsRepo).findById(1L);

        assertEquals("Product1", orderDetailsQuerryServiceImpl.findById(1L).get().getProduct().getName());
    }

    @Test
    void findByIdException() {
        doReturn(Optional.empty()).when(orderDetailsRepo).findById(1L);
        assertThrows(OrderDetailsNotFoundException.class, () -> orderDetailsQuerryServiceImpl.findById(1L));
    }

    @Test
    void findByOrderId() {
        Order order = Order.builder()
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetails orderDetails1 = OrderDetails.builder().order(order).product(product1).price(100L).quantity(1).SKU(product1.getSku()).build();
        doReturn(Optional.of(orderDetails1)).when(orderDetailsRepo).findByOrderId(1L);

        assertEquals("order@example.com", orderDetailsQuerryServiceImpl.findByOrderId(1L).get().getOrder().getOrderEmail());

    }

    @Test
    void findByOrderIdException() {
        doReturn(Optional.empty()).when(orderDetailsRepo).findByOrderId(1L);
        assertThrows(OrderDetailsNotFoundException.class, () -> orderDetailsQuerryServiceImpl.findByOrderId(1L));
    }
}