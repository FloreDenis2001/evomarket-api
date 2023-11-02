package ro.mycode.evomarketapi.orderdetails.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.dto.UpdateOrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderdetails")
@CrossOrigin
@Slf4j
public class ServerControllerOrderDetails {

    private OrderDetailsQuerryServiceImpl orderDetailsQuerryServiceImpl;

    private OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl;

    public ServerControllerOrderDetails(OrderDetailsQuerryServiceImpl orderDetailsQuerryServiceImpl, OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl) {
        this.orderDetailsQuerryServiceImpl = orderDetailsQuerryServiceImpl;
        this.orderDetailsCommandServiceImpl = orderDetailsCommandServiceImpl;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public ResponseEntity<OrderDetails> getfindById(@PathVariable long id) {
        return ResponseEntity.ok(orderDetailsQuerryServiceImpl.findById(id).get());
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/orderId/{orderId}")
    public ResponseEntity<OrderDetails> getfindByOrderId(@PathVariable long orderId) {
        return ResponseEntity.ok(orderDetailsQuerryServiceImpl.findByOrderId(orderId).get());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/add")
    public ResponseEntity<OrderDetailsDTO> addOrderDetails(@RequestBody OrderDetailsDTO orderDetails) {
        orderDetailsCommandServiceImpl.addOrderDetails(orderDetails);
        return ResponseEntity.ok(orderDetails);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public ResponseEntity<OrderDetailsDTO> updateOrderDetails(@RequestBody OrderDetailsDTO orderDetails, @RequestBody UpdateOrderDetailsDTO updateOrderDetailsDTO) {
        orderDetailsCommandServiceImpl.updateOrderDetails(orderDetails, updateOrderDetailsDTO);
        return ResponseEntity.ok(orderDetails);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public ResponseEntity<OrderDetailsDTO> deleteOrderDetails(@RequestBody OrderDetailsDTO orderDetails) {
        orderDetailsCommandServiceImpl.deleteOrderDetails(orderDetails);
        return ResponseEntity.ok(orderDetails);
    }







}
