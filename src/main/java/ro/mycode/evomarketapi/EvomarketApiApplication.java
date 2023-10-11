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
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsCommandServiceImpl;
import ro.mycode.evomarketapi.orderdetails.services.OrderDetailsQuerryService;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;
import ro.mycode.evomarketapi.user.repo.UserRepo;

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
    CommandLineRunner commandLineRunner(OrderQuerryServiceImpl orderQuerryServiceImpl, UserRepo userRepo, OrderCommandServiceImpl orderCommandServiceImpl, OrderQuerryServiceImpl orderQuerryService, OrderDetailsQuerryService orderDetailsQuerryServiceImpl, OrderDetailsCommandServiceImpl orderDetailsCommandServiceImpl, ProductCommandServiceImpl productCommandServiceImpl, ProductQuerryImplService productQuerryImplService, ProductRepo productRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo) {
        return args -> {
            log.info("Start");
//            OrderDTO orderDTO = OrderDTO.builder().userId(1L).ammount(400L).shippingAddress("Shipping Address").orderAddress("Order Address").orderEmail("denis@yahoo.com").orderPhone("1234567890").orderDate(LocalDateTime.now()).orderStatus("Pending").build();
            orderCommandServiceImpl.deleteOrder(3L);
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
