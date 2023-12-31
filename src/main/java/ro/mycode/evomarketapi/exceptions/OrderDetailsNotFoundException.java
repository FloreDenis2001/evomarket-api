package ro.mycode.evomarketapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException() {
        super("Order details not found");
    }
}
