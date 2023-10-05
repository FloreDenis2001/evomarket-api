package ro.mycode.evomarketapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductAlreadyExistException extends RuntimeException{
    public ProductAlreadyExistException() {
        super("Product already exist");
    }
}
