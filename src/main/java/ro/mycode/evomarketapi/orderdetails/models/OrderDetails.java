package ro.mycode.evomarketapi.orderdetails.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.product.models.Product;

@Table(name = "orderdetails")
@Entity(name = "OrderDetails")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter

public class OrderDetails implements Comparable<OrderDetails>{




    @Id
    @SequenceGenerator(name = "orderdetails_sequence", sequenceName = "orderdetails_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderdetails_sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "SKU", nullable = false)
    private String SKU;

    public OrderDetails(Order order, Product product, int quantity, double price, String sku) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = (long) price;
        this.SKU = sku;
    }


    @Override
    public String toString(){
        String text ="Order Id : "+this.order.getId()+"\n"+
                "Product Id : "+this.product.getId()+"\n"+
                "Quantity : "+this.quantity+"\n"+
                "Price : "+this.price+"\n"+
                "SKU : "+this.SKU+"\n";
        return text;
    }

    @Override
    public boolean equals(Object o){
        OrderDetails orderDetails = (OrderDetails) o;
        return this.order.getId().equals(orderDetails.getOrder().getId()) && this.product.getId().equals(orderDetails.getProduct().getId());
    }

    @Override
    public int compareTo(OrderDetails o) {
        if(this.price>o.getPrice())
            return 1;
        else if(this.price<o.getPrice())
            return -1;
        else
            return 0;
    }
}
