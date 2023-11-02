package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.order.services.OrderQuerryServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class OrderQuerryServiceImplTest {

    @Mock
    private OrderRepo orderRepo;

    @InjectMocks
    private OrderQuerryServiceImpl orderQuerryServiceImpl;



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

        doReturn(Optional.of(order)).when(orderRepo).findById(1L);

        assertEquals("order@example.com", orderQuerryServiceImpl.findById(1L).get().getOrderEmail());

    }

    @Test
    void findByIdException() {
        doReturn(Optional.empty()).when(orderRepo).findById(1L);
        assertThrows(RuntimeException.class, () -> orderQuerryServiceImpl.findById(1L));
    }

}