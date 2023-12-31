package ro.mycode.evomarketapi.order.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.mycode.evomarketapi.address.Address;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.user.models.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity(name = "Order")
@NoArgsConstructor
@AllArgsConstructor
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


    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "ammount", nullable = false)
    private Long ammount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "shipping_country")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "shipping_number")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "shipping_postal_code"))
    })
    private Address shippingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "order_country")),
            @AttributeOverride(name = "city", column = @Column(name = "order_city")),
            @AttributeOverride(name = "street", column = @Column(name = "order_street")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "order_number")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "order_postal_code"))
     })
    private Address orderAddress;

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


    @Column(name = "order_notes")
    private String notes;





    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();

    public void addOrderDetails(OrderDetails orderDetails) {
        this.orderDetailsSet.add(orderDetails);
        orderDetails.setOrder(this);
    }


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_id_fk"), insertable = false, updatable = false)
    private User user;

    @Override
    public String toString() {
        String text = "Order id : " + this.id + "\n";
        text += "User id : " + this.userId + "\n";
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
