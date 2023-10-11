package ro.mycode.evomarketapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(reason = "Order already exist",value = HttpStatus.CONFLICT)
public class OrderAlreadyExistException extends RuntimeException{
    public OrderAlreadyExistException() {
        super("Order already exist");
    }
}
