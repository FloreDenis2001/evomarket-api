package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
class ProductQuerryImplServiceTest {

    @Mock
    private ProductRepo productRepo;


    @InjectMocks
    private ProductQuerryImplService productQuerryImplService;





    @BeforeEach
    void setUp() {


    }

    @Test
    void getAllProducts() {
    }

    @Test
    void findById() {
    }

    @Test
    void getProductBySKU() {
    }

    @Test
    void getProductsByCategory() {
    }

    @Test
    void getProductsByPriceBetween() {
    }

    @Test
    void getProductsByPriceLessThan() {
    }

    @Test
    void getProductsByPriceGreaterThan() {
    }

    @Test
    void getProductsByPriceLessThanAndCategory() {
    }

    @Test
    void getProductsByPriceGreaterThanAndCategory() {
    }

    @Test
    void getProductsByPriceBetweenAndCategory() {
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