package ro.mycode.evomarketapi.orderdetails.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import ro.mycode.evomarketapi.orders.models.Orders;
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

//    @Id
//
//
//
//    @GenericGenerator(
//            name = "string-sequence-generator", strategy = "ro.mycode.evomarketapi.system.StringSequenceGenerator"
//    )
//
//    @GeneratedValue(generator = "string-sequence-generator")
//
//    @Column(name = "id", nullable = false)
//    private Long id;
    @EmbeddedId
    private OrderDetailsId id;

    @ManyToOne
    @MapsId("orderId")
    private Orders order;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "SKU", nullable = false)
    private String SKU;

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
