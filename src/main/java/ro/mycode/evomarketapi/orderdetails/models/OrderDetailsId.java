package ro.mycode.evomarketapi.orderdetails.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailsId implements Serializable {
    private Long orderId;
    private Long productId;

}


