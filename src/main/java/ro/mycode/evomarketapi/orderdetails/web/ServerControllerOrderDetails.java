package ro.mycode.evomarketapi.orderdetails.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryServiceImpl;

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
//    @RequestMapping("/all")
    public ResponseEntity<OrderDetails> getOrderDetailsById(long id) {
        return ResponseEntity.ok(orderDetailsQuerryServiceImpl.findById(id).get());
    }


}
