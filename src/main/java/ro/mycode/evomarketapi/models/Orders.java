package ro.mycode.evomarketapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class Orders {

    @Id
    @SequenceGenerator(
            name = "orders_sequence",
            sequenceName = "orders_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_sequence")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "cupon_id", nullable = false)
    private Long cupon_id;

    @Column(name = "order_status_id", nullable = false)
    private Long order_status_id;

    @Column(name = "order_approved_at", nullable = false)

    private LocalDateTime order_approved_at;

    @Column(name = "order_delivered_carrier_date", nullable = false)
    private LocalDateTime order_delivered_carrier_date;

    @Column(name = "order_delivered_customer_date", nullable = false)
    private LocalDateTime order_delivered_customer_date;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;
}
