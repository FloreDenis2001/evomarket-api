package ro.mycode.evomarketapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Table(name = "orderstatuses")
@Entity(name = "OrderStatuses")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class OrderStatuses {
    @Id
    @SequenceGenerator(
            name = "orderstatuses_sequence",
            sequenceName = "orderstatuses_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderstatuses_sequence")
    private Long id;

    @Column(name = "status_name", nullable = false)
    private String status_name;

    @Column(name = "color", nullable = false)
    private String color;


    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    @Column(name = "created_by", nullable = false)
    private String created_by;

    @Column(name = "updated_by", nullable = false)
    private String updated_by;


}
