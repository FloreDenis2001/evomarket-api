package ro.mycode.evomarketapi.models;
//ID_PRODUCT,PRODUCT_NAME,DESCRIPTION,CATEGORY,PRICE,STOCK,IMAGES,DATA_ADDED,DATA_UPDATE

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Table(name = "product")
@Entity(name="Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Product {
   @Id
   @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1)
   @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence")
    private Long id;

   @Column(name = "product_name", nullable = false)
   @Size(min = 3, max = 50,message = "Product name must be between 3 and 50 characters")
    private String product_name;
@Column(name="SKU",nullable = false)
    private String SKU;

//private Object Image;
@Column(name="regular_price",nullable = false)
private Long regular_price;

@Column(name="discount_price",nullable = false)
private Long discount_price;

@Column(name="quantity",nullable = false)
private int quantity;

@Column(name="short_description",nullable = false)
private String short_description;

@Column(name="product_description",nullable = false)
private String product_description;

@Column(name="product_note",nullable = false)
private String product_note;

@Column(name="published",nullable = false)
private boolean published ;

@Column(name="created_at",nullable = false)
private LocalDateTime created_at;


@Column(name="updated_at",nullable = false)
private LocalDateTime updated_at;


@Column(name="created_by",nullable = false)
private String created_by;


@Column(name="updated_by",nullable = false)
private String updated_by;

}
