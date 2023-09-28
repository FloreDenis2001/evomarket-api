package ro.mycode.evomarketapi;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class EvomarketApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvomarketApiApplication.class, args);

    }


    @Bean

    @Transactional
    CommandLineRunner commandLineRunner(ProductQuerryImplService productQuerryImplService,ProductRepo productRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo) {
        return args -> {

//            Product product1 = Product.builder().name("Product1").description("Description1") .category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//            Product product2 = Product.builder().name("Product2").description("Description2") .category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//            Product product3 = Product.builder().name("Product3").description("Description3") .category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//            Product product4 = Product.builder().name("Product4").description("Description4") .category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//            Product product5 = Product.builder().name("Product5").description("Description5") .category("category").price(100L).SKU("SKU14428876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//            Product product6 = Product.builder().name("Product6").description("Description6") .category("category").price(100L).SKU("SKU17519776").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//
//
//
//
//            productRepo.saveAllAndFlush(Arrays.asList(product1,product2,product3,product4,product5,product6));
//
//
//
//
//            Order order = Order.builder()
//                    .ammount(100L)
//                    .shippingAddress("Shipping Address")
//                    .orderAddress("Order Address")
//                    .orderEmail("order@example.com")
//                    .orderPhone("1234567890")
//                    .orderDate(LocalDateTime.now())
//                    .orderStatus("Pending")
//                    .build();
//
//
//            OrderDetails orderDetails1 = OrderDetails.builder().order(order).product(product1).price(100L).quantity(1).SKU("SKU178876").build();
//
//            order.addOrderDetails(orderDetails1);
//            product1.addOrderDetails(orderDetails1);
//
//            orderRepo.saveAndFlush(order);
//            List<Product> products = productQuerryImplService.getAllProducts();
//            for (Product product : products) {
//                log.info(product.toString());
//            }


              Product findProduct=productRepo.getProductsById(4L).get();

                log.info(findProduct.toString());
        };
    }
}
