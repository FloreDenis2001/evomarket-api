package ro.mycode.evomarketapi.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryServiceImpl;
import ro.mycode.evomarketapi.orderdetails.web.ServerControllerOrderDetails;
import ro.mycode.evomarketapi.product.models.Product;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = EvomarketApiApplication.class)
class ServerControllerOrderDetailsITTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ServerControllerOrderDetails serverControllerOrderDetails;

    @Autowired
    private OrderDetailsQuerryServiceImpl orderDetailsQuerryServiceImpl;

    @Autowired
    private OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl;


    @MockBean
    private OrderDetailsRepo orderDetailsRepo;
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void getfindById() throws Exception {

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

        mockMvc.perform(get("/api/v1/order-details/id/1").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(orderDetails1)));


    }

    @Test
    void getfindByOrderId() throws Exception{

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

        mockMvc.perform(get("/api/v1/order-details/orderId/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(orderDetails1)));

    }
//
//    @Test
//    void addOrderDetails() throws Exception{
//        User user=new User();
//        user.setId(1L);
//        user.setFirstName("Andrei");
//        user.setLastName("Popescu");
//        user.setEmail("andreipopescu@yahoo.com");
//        user.setPassword("andrei1234");
//        user.setPhoneNumber("0722222222");
//        user.setUserRole(UserRole.ADMIN);
//        user.setRegisteredAt(LocalDateTime.now());
//        user.setCreatedAt(LocalDateTime.now());
//        user.setActive(true);
//
//        Order order = Order.builder().id(1L).userId(1L).user(user)
//                .ammount(100L)
//                .shippingAddress("Shipping Address")
//                .orderAddress("Order Address")
//                .orderEmail("order@example.com")
//                .orderPhone("1234567890")
//                .orderDate(LocalDateTime.now())
//                .orderStatus("Pending")
//                .build();
//
//        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//        OrderDetailsDTO orderDetailsDTO=OrderDetailsDTO.builder().order(order).product(product1).price(300L).quantity(3).SKU("SKU178876").build();
//
//        doReturn(Optional.empty()).when(orderDetailsRepo).findByOrderId(order.getId());
//
//        mockMvc.perform(post("/api/v1/order-details/add").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(orderDetailsDTO))).andExpect(status().isOk());
//
//
//    }
//
//    @Test
//    void updateOrderDetails() throws Exception {
//
//
//        User user=new User();
//        user.setId(1L);
//        user.setFirstName("Andrei");
//        user.setLastName("Popescu");
//        user.setEmail("andreipopescu@yahoo.com");
//        user.setPassword("andrei1234");
//        user.setPhoneNumber("0722222222");
//        user.setUserRole(UserRole.ADMIN);
//        user.setRegisteredAt(LocalDateTime.now());
//        user.setCreatedAt(LocalDateTime.now());
//        user.setActive(true);
//
//        Order order = Order.builder().id(1L).userId(1L).user(user)
//                .ammount(100L)
//                .shippingAddress("Shipping Address")
//                .orderAddress("Order Address")
//                .orderEmail("order@example.com")
//                .orderPhone("1234567890")
//                .orderDate(LocalDateTime.now())
//                .orderStatus("Pending")
//                .build();
//
//        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//        OrderDetailsDTO orderDetailsDTO=OrderDetailsDTO.builder().order(order).product(product1).price(300L).quantity(3).SKU("SKU178876").build();
//
//
//        UpdateOrderDetailsDTO updateOrderDetailsDTO= UpdateOrderDetailsDTO.builder().price(300L).quantity(3).build();
//
//        doReturn(Optional.of(orderDetailsDTO)).when(orderDetailsRepo).findByOrderId(order.getId());
//
//        mockMvc.perform(put("/api/v1/order-details/update").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(updateOrderDetailsDTO))).andExpect(status().isOk());
//
//
//
//    }

    @Test
    void deleteOrderDetails() {
    }
}