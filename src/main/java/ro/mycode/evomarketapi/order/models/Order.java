package ro.mycode.evomarketapi.order.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity(name = "Order")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter

public class Order implements Comparable<Order> {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "id")


    private Long id;

    @Column(name = "ammount", nullable = false)
    private Long ammount;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "order_address", nullable = false)
    private String orderAddress;

    @Column(name = "order_email", nullable = false)
    private String orderEmail;
    @Column(name = "order_phone", nullable = false)
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters")
    private String orderPhone;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;


    @Column(name = "order_status", nullable = false)
    @Size(min = 3, max = 10, message = "Order status must be between 3 and 10 characters")
    private String orderStatus;

    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();

    public void addOrderDetails(OrderDetails orderDetails) {
        this.orderDetailsSet.add(orderDetails);
        orderDetails.setOrder(this);
    }

    @Override
    public String toString() {
        String text = "Order id : " + this.id + "\n";
        text += "Ammount : " + this.ammount + "\n";
        text += "Shipping address : " + this.shippingAddress + "\n";
        text += "Order address : " + this.orderAddress + "\n";
        text += "Order email : " + this.orderEmail + "\n";
        text += "Order phone : " + this.orderPhone + "\n";
        text += "Order date : " + this.orderDate + "\n";
        text += "Order status : " + this.orderStatus + "\n";
        return text;
    }


    @Override
    public boolean equals(Object o) {
        Order order = (Order) o;
        return this.id.equals(order.getId());
    }


    @Override
    public int compareTo(Order o) {
        if (this.ammount > o.getAmmount()) return 1;
        else if (this.ammount < o.getAmmount()) return -1;
        else return 0;
    }


}
