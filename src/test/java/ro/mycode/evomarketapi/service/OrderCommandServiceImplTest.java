package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.OrderAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.OrderNotFoundException;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.order.services.OrderCommandServiceImpl;
import ro.mycode.evomarketapi.utils.Mapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderCommandServiceImplTest {

    @Mock
    private OrderRepo orderRepo;

    @InjectMocks
    private OrderCommandServiceImpl orderCommandService;

    @Captor
    ArgumentCaptor<Order> orderArgumentCaptor;
    Mapper mapper = new Mapper();

    @Test
    void addOrder() {

        OrderDTO orderDTO = OrderDTO.builder().ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        orderCommandService.addOrder(orderDTO);
        doReturn(Optional.of(mapper.convertOrdetDTOtoOrder(orderDTO))).when(orderRepo).findById(1L);
        assertEquals("Shipping Address", orderRepo.findById(1L).get().getShippingAddress());


    }

    @Test
    void addOrderException() {
        OrderDTO orderDTO = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        doReturn(Optional.of(mapper.convertOrdetDTOtoOrder(orderDTO))).when(orderRepo).findById(orderDTO.id());
        assertThrows(OrderAlreadyExistException.class, () -> orderCommandService.addOrder(orderDTO));


    }

    @Test
    void updateOrder() {
        OrderDTO orderDTO = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        OrderDTO orderDTO2 = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("floredenis5@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        doReturn(Optional.of(mapper.convertOrdetDTOtoOrder(orderDTO))).when(orderRepo).findById(orderDTO.id());
        orderCommandService.updateOrder(orderDTO2);
        assertEquals("floredenis5@yahoo.com", orderRepo.findById(1L).get().getOrderEmail());

    }


    @Test
    void updateOrderException() {
        OrderDTO orderDTO = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        doReturn(Optional.empty()).when(orderRepo).findById(orderDTO.id());
        assertThrows(OrderNotFoundException.class, () -> orderCommandService.updateOrder(orderDTO));
    }

    @Test
    void deleteOrder() {
        OrderDTO orderDTO = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
        doReturn(Optional.of(mapper.convertOrdetDTOtoOrder(orderDTO))).when(orderRepo).findById(orderDTO.id());
        orderCommandService.deleteOrder(orderDTO.id());
        verify(orderRepo).delete(orderArgumentCaptor.capture());
        assertEquals(100L, orderArgumentCaptor.getValue().getAmmount());
    }

    @Test
    void deleteOrderException() {
        OrderDTO orderDTO = OrderDTO.builder().id(1L).ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderStatus("Pending").build();
          doReturn(Optional.empty()).when(orderRepo).findById(orderDTO.id());
        assertThrows(OrderNotFoundException.class, () -> orderCommandService.deleteOrder(orderDTO.id()));
    }
}