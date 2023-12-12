package ro.mycode.evomarketapi.order.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.services.OrderCommandServiceImpl;
import ro.mycode.evomarketapi.order.services.OrderQuerryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
@Slf4j
public class ServerControllerOrder {

    private OrderCommandServiceImpl orderCommandServiceImpl;

    private OrderQuerryServiceImpl orderQuerryServiceImpl;

    public ServerControllerOrder(OrderCommandServiceImpl orderCommandServiceImpl, OrderQuerryServiceImpl orderQuerryServiceImpl) {
        this.orderCommandServiceImpl = orderCommandServiceImpl;
        this.orderQuerryServiceImpl = orderQuerryServiceImpl;
    }




    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id) {
        return ResponseEntity.ok(orderQuerryServiceImpl.findById(id).get());
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/add")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) {
//        orderCommandServiceImpl.addOrder(order);
        return ResponseEntity.ok(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO order) {
        orderCommandServiceImpl.updateOrder(order);
        return ResponseEntity.ok(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable long id) {
        orderCommandServiceImpl.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
