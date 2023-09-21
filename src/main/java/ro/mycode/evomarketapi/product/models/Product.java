package ro.mycode.evomarketapi.product.models;
//ID_PRODUCT,PRODUCT_NAME,DESCRIPTION,CATEGORY,PRICE,STOCK,IMAGES,DATA_ADDED,DATA_UPDATE

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Product  implements Comparable<Product>{
    @Id


    @GenericGenerator(
            name = "string-sequence-generator", strategy = "ro.mycode.evomarketapi.system.StringSequenceGenerator"
    )

    @GeneratedValue(generator = "string-sequence-generator")

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    private String name;


    @Column(name = "SKU", nullable = false)
    @Size(min = 8, max = 12, message = "SKU must be between 8 and 12 characters")
    private String SKU;

    @Column(name = "price", nullable = false)
    private Long price;


    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "weight", nullable = false)
    private double weight;


    @Column(name = "description", nullable = false)
    @Size(min = 10, max = 100, message = "Description must be between 3 and 50 characters")
    private String description;


    @Column(name = "category", nullable = false)
    private String category;


    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();


    @Override
    public String toString() {
        String text = "Product : " + this.name + "\n";
        text += "SKU : " + this.SKU + "\n";
        text += "Price : " + this.price + "\n";
        text += "Quantity : " + this.quantity + "\n";
        text += "Weight : " + this.weight + "\n";
        text += "Description : " + this.description + "\n";
        text += "Category : " + this.category + "\n";
        text += "Created Date : " + this.createdDate + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
      Product p = (Product) o;
      return this.SKU.equals(p.SKU);
    }

    @Override
    public int compareTo(Product o) {
     if(this.price > o.price)
         return 1;
     else if(this.price < o.price)
         return -1;
     else
         return 0;
    }



}
