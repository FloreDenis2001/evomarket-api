package ro.mycode.evomarketapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetailsId;
import ro.mycode.evomarketapi.product.models.Product;

import java.time.LocalDateTime;

@SpringBootApplication
public class EvomarketApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvomarketApiApplication.class, args);

    }


    @Bean
    CommandLineRunner commandLineRunner(

    ) {
        return args -> {

            Product product = new Product().builder().id("1").name("Laptop").SKU("KF1291KALE2").description("Laptop Lenovo").price(5321L).quantity(1).weight(25.3).category("telefoane").createdDate(LocalDateTime.now()).build();
            Order order = new Order().builder().id("1").orderPhone("0751389111").orderStatus("cancel").orderDate(LocalDateTime.now()).orderAddress("Bucuresti Soseaua Pipera 16").ammount(5321L).build();
            OrderDetailsId orderDetailsId = new OrderDetailsId().builder().orderId("1").productId("1").build();
            OrderDetails orderDetails = new OrderDetails().builder().id(orderDetailsId).order(order).product(product).quantity(1).price(5321L).SKU("KF1291KALE2").build();

            product.getOrderDetailsSet().add(orderDetails);
            order.getOrderDetailsSet().add(orderDetails);


        };
    }
}
