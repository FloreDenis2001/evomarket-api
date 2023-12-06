package ro.mycode.evomarketapi.product.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
public class Product implements Comparable<Product> {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;


    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    private String name;


    @Column(name = "sku", nullable = false, unique = true)
    @Size(min = 8, max = 12, message = "SKU must be between 8 and 12 characters")

    private String sku;

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

    @Column(name = "rating", nullable = false, columnDefinition = "double default 0")
    private double rating;


    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonManagedReference
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();



    public void addOrderDetails(OrderDetails orderDetails) {
        this.orderDetailsSet.add(orderDetails);
        orderDetails.setProduct(this);
    }

    @Override
    public String toString() {
        String text = "Product : " + this.name + "\n";
        text += "Id:  " + this.id + "\n";
        text += "SKU : " + this.sku + "\n";
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
        return this.sku.equals(p.sku);
    }

    @Override
    public int compareTo(Product o) {
        if (this.price > o.price)
            return 1;
        else if (this.price < o.price)
            return -1;
        else
            return 0;
    }


}
