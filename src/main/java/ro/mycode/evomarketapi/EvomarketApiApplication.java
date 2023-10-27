package ro.mycode.evomarketapi;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.order.repo.OrderRepo;
import ro.mycode.evomarketapi.order.services.OrderCommandServiceImpl;
import ro.mycode.evomarketapi.order.services.OrderQuerryServiceImpl;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryService;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;
import ro.mycode.evomarketapi.user.services.UserCommandService;
import ro.mycode.evomarketapi.user.services.UserCommandServiceImpl;
import ro.mycode.evomarketapi.user.services.UserQuerryServiceImpl;

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
    CommandLineRunner commandLineRunner(OrderQuerryServiceImpl orderQuerryServiceImpl, UserRepo userRepo, OrderCommandServiceImpl orderCommandServiceImpl,
                                        OrderQuerryServiceImpl orderQuerryService,
                                        OrderDetailsQuerryService orderDetailsQuerryServiceImpl,
                                        OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl,
                                        ProductCommandServiceImpl productCommandServiceImpl,
                                        ProductQuerryImplService productQuerryImplService,
                                        ProductRepo productRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo,
                                        UserCommandServiceImpl userCommandServiceImpl, UserQuerryServiceImpl userQuerryServiceImpl) {
        return args -> {
            log.info("Start");

            Product product1 = Product.builder().name("Product1").description("Description1") .category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

            Product product2 = Product.builder().name("Product2").description("Description2") .category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

            Product product3 = Product.builder().name("Product3").description("Description3") .category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

            Product product4 = Product.builder().name("Product4").description("Description4") .category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

            Product product5 = Product.builder().name("Product5").description("Description5") .category("category").price(100L).SKU("SKU14428876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

            Product product6 = Product.builder().name("Product6").description("Description6") .category("category").price(100L).SKU("SKU17519776").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();





            productRepo.saveAllAndFlush(Arrays.asList(product1,product2,product3,product4,product5,product6));



        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200", "http://localhost"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers", "Access-Control-Allow-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
