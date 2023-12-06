package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.OrderDetailsAlreadyExistsException;
import ro.mycode.evomarketapi.exceptions.OrderDetailsNotFoundException;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.dto.UpdateOrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.utils.Mapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderDetailsCommandServiceTest {

    @Mock
    private OrderDetailsRepo orderDetailsRepo;

    @InjectMocks
    private OrderDetailsCommandServiceImpl orderDetailsCommandService;

    Mapper mapper = new Mapper();


    @Captor
    ArgumentCaptor<OrderDetails> orderDetailsArgumentCaptor;


    @Test
    public void addOrderDetailsTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();

        orderDetailsCommandService.addOrderDetails(orderDetailsDTO);

        doReturn(Optional.of(mapper.convertOrderDetailsDTOToOrderDetails(orderDetailsDTO))).when(orderDetailsRepo).findByOrderId(1L);

        assertEquals("Product1", orderDetailsRepo.findByOrderId(1L).get().getProduct().getName());
    }

    @Test
    public void addOrderDetailsExceptionTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();

        doReturn(Optional.of(mapper.convertOrderDetailsDTOToOrderDetails(orderDetailsDTO))).when(orderDetailsRepo).findByOrderId(1L);

        assertThrows(OrderDetailsAlreadyExistsException.class, () -> orderDetailsCommandService.addOrderDetails(orderDetailsDTO));
    }

    @Test

    public void updateOrderDetailsTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();

        UpdateOrderDetailsDTO updateOrderDetailsDTO = UpdateOrderDetailsDTO.builder().price(200L).quantity(2).build();
        doReturn(Optional.of(mapper.convertOrderDetailsDTOToOrderDetails(orderDetailsDTO))).when(orderDetailsRepo).findByOrderId(1L);
        orderDetailsCommandService.updateOrderDetails(orderDetailsDTO, updateOrderDetailsDTO);
        assertEquals(200L, orderDetailsRepo.findByOrderId(1L).get().getPrice());
    }


    @Test
    public void updateOrderDetailsExceptionTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();

        UpdateOrderDetailsDTO updateOrderDetailsDTO = UpdateOrderDetailsDTO.builder().price(200L).quantity(2).build();

        doReturn(Optional.empty()).when(orderDetailsRepo).findByOrderId(1L);

        assertThrows(OrderDetailsNotFoundException.class, () -> orderDetailsCommandService.updateOrderDetails(orderDetailsDTO, updateOrderDetailsDTO));
    }

    @Test
    public void deleteOrderDetailsTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();

        doReturn(Optional.of(mapper.convertOrderDetailsDTOToOrderDetails(orderDetailsDTO))).when(orderDetailsRepo).findByOrderId(1L);

        orderDetailsCommandService.deleteOrderDetails(orderDetailsDTO);

        verify(orderDetailsRepo).delete(orderDetailsArgumentCaptor.capture());

        assertEquals("Product1", orderDetailsArgumentCaptor.getValue().getProduct().getName());

    }

    @Test
    public void deleteOrderDetailsExceptionTest() {
        Order order = Order.builder().id(1L)
                .ammount(100L)
                .shippingAddress("Shipping Address")
                .orderAddress("Order Address")
                .orderEmail("order@example.com")
                .orderPhone("1234567890")
                .orderDate(LocalDateTime.now())
                .orderStatus("Pending")
                .build();

        Product product = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        OrderDetailsDTO orderDetailsDTO = OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();


        doReturn(Optional.empty()).when(orderDetailsRepo).findByOrderId(1L);

        assertThrows(OrderDetailsNotFoundException.class, () -> orderDetailsCommandService.deleteOrderDetails(orderDetailsDTO));

    }

}
