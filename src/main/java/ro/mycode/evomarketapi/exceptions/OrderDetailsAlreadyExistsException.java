package ro.mycode.evomarketapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrderDetailsAlreadyExistsException extends RuntimeException{
    public OrderDetailsAlreadyExistsException() {
        super("Order details with this product already exists");
    }
}
