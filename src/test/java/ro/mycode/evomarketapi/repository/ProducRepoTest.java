package ro.mycode.evomarketapi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
public class ProducRepoTest {
    @Autowired
    ProductRepo productRepo;

    @BeforeEach
    void deleteAll() {
        productRepo.deleteAll();
    }

    @Test
    void getAllProductsTest() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);

        assertEquals(1, productRepo.getAllProducts().size());
    }




    @Test
    void getProductBySKUTest() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.save(product1);
        assertEquals("category", productRepo.getProductBySKU("SKU17887416").get().getCategory());
    }

    @Test
    void getProductByIdTest() {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);

        Product p3=productRepo.findById(1L).get();
        assertEquals("Product1", p3.getName());
    }



//    @Test
//    void getProductByCategoryTest(){
//        Product product1 = Product.builder().name("Product1").description("Description1") .category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//        productRepo.save(product1);
//        assertEquals(1,productRepo.getProductsByCategory("category").get().size());
//
//    }

}
