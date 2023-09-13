package ro.mycode.evomarketapi.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Table(name = "orderitems")
@Entity(name = "OrderItems")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class OrderItems {

    @Id
    @SequenceGenerator(
            name = "orderitems_sequence",
            sequenceName = "orderitems_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitems_sequence")
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @Column(name = "quantity", nullable = false)

    private int quantity;


    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name="shipping_id",nullable = false)
    private Long shipping_id;


}
