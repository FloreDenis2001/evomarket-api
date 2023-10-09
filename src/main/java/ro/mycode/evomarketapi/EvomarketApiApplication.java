package ro.mycode.evomarketapi;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.order.services.OrderCommandService;
import ro.mycode.evomarketapi.order.services.OrderCommandServiceImpl;
import ro.mycode.evomarketapi.order.services.OrderQuerryService;
import ro.mycode.evomarketapi.order.services.OrderQuerryServiceImpl;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.dto.UpdateOrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryService;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryServiceImpl;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
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
    CommandLineRunner commandLineRunner(OrderCommandServiceImpl orderCommandServiceImpl, OrderQuerryServiceImpl orderQuerryService, OrderDetailsQuerryService orderDetailsQuerryServiceImpl, OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl, ProductCommandServiceImpl productCommandServiceImpl, ProductQuerryImplService productQuerryImplService, ProductRepo productRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo) {
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
//            Product product11 = Product.builder().name("Product1").description("Description1") .category("category").price(100L).SKU("SKU4000116").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//
//           productRepo.saveAndFlush(product11);
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
//                product.setRating(0);
//            }
//
//
//              Product findProduct=productRepo.getProductsById(4L).get();
//
//                log.info(findProduct.toString());
//
//            Product product11=productQuerryImplService.getProductById(4L);
//
//            log.info(product11.toString());
//
//            Product product14=productQuerryImplService.getProductBySKU("SKU17887416");
//            log.info(product14.toString());

//            ProductDTO productDTO=ProductDTO.builder().name("ProductDTO").description("Description1").category("category").price(100L).SKU("SK94142135").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//            productCommandServiceImpl.addProduct(productDTO);


//            productCommandServiceImpl.deleteProduct("SK94142135");


//            UpdateProductRequest updateProductRequest = UpdateProductRequest.builder().name("ProductUpdate2").description("Description1").category("category").price(110L).quantity(59).weight(4).build();
//            String SKU = "SKU17890876";
//            productCommandServiceImpl.updateProduct(SKU, updateProductRequest);


            Product product = productRepo.findById(4L).get();
            Order order = orderRepo.findById(1L).get();
//
//            OrderDetailsDTO orderDetailsDTO=OrderDetailsDTO.builder().order(order).product(product).price(300L).quantity(3).SKU("SKU178876").build();
//            orderDetailsCommandServiceImpl.addOrderDetails(orderDetailsDTO);
//            UpdateOrderDetailsDTO updateOrderDetailsDTO=UpdateOrderDetailsDTO.builder().price(300L).quantity(3).build();
//            orderDetailsCommandServiceImpl.updateOrderDetails(orderDetailsDTO,updateOrderDetailsDTO);
//            orderDetailsCommandServiceImpl.deleteOrderDetails(orderDetailsDTO);

            OrderDTO orderDTO = OrderDTO.builder().ammount(100L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderDate(LocalDateTime.now()).orderStatus("Pending").build();
            orderCommandServiceImpl.addOrder(orderDTO);

        };
    }
}
