package ro.mycode.evomarketapi.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.checkerframework.checker.units.qual.C;

@Table(name = "categories")
@Entity(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
public class Categories {

    @Id
    @SequenceGenerator(
            name = "categories_sequence",
            sequenceName = "categories_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_sequence")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String category_name;

    @Column(name = "category_description", nullable = false)
    private String category_description;

    @Column(name = "image_path", nullable = false)
    private String image_path;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "parent_id", nullable = false)
    private Long parent_id;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "updated_at", nullable = false)
    private String updated_at;

    @Column(name = "created_by", nullable = false)
    private String created_by;

    @Column(name = "updated_by", nullable = false)
    private String updated_by;
}
