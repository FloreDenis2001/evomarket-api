package ro.mycode.evomarketapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDateTime;

@Table(name = "coupons")
@Entity(name = "Coupons")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class Coupons {

    @Id
    @SequenceGenerator(
            name = "coupons_sequence",
            sequenceName = "coupons_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupons_sequence")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "coupon_description", nullable = false)
    private String coupon_description;

    @Column(name = "times_used", nullable = false)
    private int times_used;

    @Column(name = "max_usage", nullable = false)
    private int max_usage;

    @Column(name = "discount_value", nullable = false)
    private Long discount_value;

    @Column(name = "discount_type", nullable = false)
    private String discount_type;

    @Column(name = "coupon_start_date", nullable = false)
    private LocalDateTime coupon_start_date;

    @Column(name = "coupon_end_date", nullable = false)
    private LocalDateTime coupon_end_date;


    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    @Column(name = "created_by", nullable = false)
    private String created_by;

    @Column(name = "updated_by", nullable = false)
    private String updated_by;
}
