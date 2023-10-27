package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Captor;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
class ProductQuerryImplServiceTest {

    @Mock
    private ProductRepo productRepo;


    @InjectMocks
    private ProductQuerryImplService productQuerryImplService;

    @InjectMocks
    private ProductCommandServiceImpl productCommandServiceImpl;


    @Captor
    ArgumentCaptor<String> carFieldsArgumentCapture;




    @Test
    void getAllProducts() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(listOfProducts).when(productRepo).findAll();

        assertEquals(4, productQuerryImplService.getAllProducts().size());

    }

    @Test
    void findById() {
        Product product4 = Product.builder().id(4L).name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(Optional.of(product4)).when(productRepo).findById(product4.getId());

        assertEquals("Product4", productQuerryImplService.findById(product4.getId()).getName());
    }

    @Test
    void getProductBySKU() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductBySKU("SKU17887419");


        assertEquals("Product3", productQuerryImplService.getProductBySKU("SKU17887419").getName());
    }

    @Test
    void getProductsByCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(listOfProducts)).when(productRepo).getProductsByCategory("category");

        assertEquals(4, productQuerryImplService.getProductsByCategory("category").size());
    }

    @Test
    void getProductsByPriceBetween() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(90L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(140L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(320L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(listOfProducts)).when(productRepo).getProductsByPriceBetween(20L, 400L);

        assertEquals(4, productQuerryImplService.getProductsByPriceBetween(20L, 400L).size());


    }

    @Test
    void getProductsByPriceLessThan() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(500L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(840L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(930L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductsByPriceLessThan(450L);

        assertEquals(1, productQuerryImplService.getProductsByPriceLessThan(450L).size());

    }

    @Test
    void getProductsByPriceGreaterThan() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductsByPriceGreaterThan(350L);

        assertEquals(1, productQuerryImplService.getProductsByPriceGreaterThan(350L).size());
    }

    @Test
    void getProductsByPriceLessThanAndCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(500L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(840L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(930L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductsByPriceLessThanAndCategory(450L, "category1");

        assertEquals(1, productQuerryImplService.getProductsByPriceLessThanAndCategory(450L, "category1").size());

    }


    @Test
    void getProductsByPriceGreaterThanAndCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category1").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductsByPriceGreaterThanAndCategory(350L, "category1");

        assertEquals(1, productQuerryImplService.getProductsByPriceGreaterThanAndCategory(350L, "category1").size());
    }

    @Test
    void getProductsByPriceBetweenAndCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(90L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category1").price(140L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category1").price(320L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1, product2, product3, product4);

        doReturn(Optional.of(product4)).when(productRepo).getProductsByPriceBetweenAndCategory(20L, 400L, "category1");

        assertEquals(1, productQuerryImplService.getProductsByPriceBetweenAndCategory(20L, 400L, "category1").size());

    }

    @Test
    void getProductsByPriceLessThanAndCategoryAndName() {


    }

    @Test
    void getProductsByPriceGreaterThanAndCategoryAndName() {
    }

    @Test
    void getProductsByPriceBetweenAndCategoryAndName() {
    }

    @Test
    void getProductsByPriceLessThanAndName() {
    }

    @Test
    void getProductsByPriceGreaterThanAndName() {
    }

    @Test
    void getProductsByPriceBetweenAndName() {
    }
}