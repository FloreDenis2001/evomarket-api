package ro.mycode.evomarketapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Table(name = "addresses")
@Entity(name = "Addresses")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Data
public class Addresses {
    @Id
    @SequenceGenerator(
            name = "addresses_sequence",
            sequenceName = "addresses_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_sequence")
    private Long id;


    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "address_line1", nullable = false)
    private String address_line1;


    @Column(name = "address_line2", nullable = false)
    private String address_line2;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;


    @Column(name = "country", nullable = false)
    private String country;


    @Column(name = "city", nullable = false)
    private String city;


}
