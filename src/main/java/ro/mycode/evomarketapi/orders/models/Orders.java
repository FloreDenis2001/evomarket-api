package ro.mycode.evomarketapi.orders.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class Orders implements Comparable<Orders>{

    @Id


    @GenericGenerator(name = "string-sequence-generator", strategy = "ro.mycode.evomarketapi.system.StringSequenceGenerator")

    @GeneratedValue(generator = "string-sequence-generator")

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;


    @Column(name = "ammount", nullable = false)
    private Long ammount;

    @Column(name = "shipping_address", nullable = false)
    private String shipping_address;

    @Column(name = "order_address", nullable = false)
    private String order_address;

    @Column(name = "order_email", nullable = false)
    private String order_email;
    @Column(name = "order_phone", nullable = false)
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters")
    private String order_phone;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime order_date;


    @Column(name = "order_status", nullable = false)
    @Size(min = 3, max = 10, message = "Order status must be between 3 and 10 characters")
    private String order_status;


    @Override
    public String toString() {
        String text = "Order id : " + this.id + "\n";
        text += "User id : " + this.user_id + "\n";
        text += "Ammount : " + this.ammount + "\n";
        text += "Shipping address : " + this.shipping_address + "\n";
        text += "Order address : " + this.order_address + "\n";
        text += "Order email : " + this.order_email + "\n";
        text += "Order phone : " + this.order_phone + "\n";
        text += "Order date : " + this.order_date + "\n";
        text += "Order status : " + this.order_status + "\n";
        return text;
    }


    @Override
    public boolean equals(Object o) {
        Orders order = (Orders) o;
        return this.id.equals(order.getId());
    }


    @Override
    public int compareTo(Orders o) {
        if(this.ammount > o.getAmmount())
            return 1;
        else if(this.ammount < o.getAmmount())
            return -1;
        else
            return 0;
    }



}
