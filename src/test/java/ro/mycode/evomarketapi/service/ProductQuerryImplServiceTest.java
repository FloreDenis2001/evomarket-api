package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Captor;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductQuerryImplServiceTest {

    @Mock
    private ProductRepo productRepo;


    @InjectMocks
    private ProductQuerryImplService productQuerryImplService;




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
    void getAllProductsException(){
        doReturn(List.of()).when(productRepo).findAll();
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getAllProducts());
    }

    @Test
    void findById() {
        Product product4 = Product.builder().id(4L).name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(Optional.of(product4)).when(productRepo).findById(product4.getId());

        assertEquals("Product4", productQuerryImplService.findById(product4.getId()).getName());
    }

    @Test
    void findByIdException(){
        doReturn(Optional.empty()).when(productRepo).findById(4L);
        assertThrows(ProductNotFoundException.class, () -> productQuerryImplService.findById(4L));
    }

    @Test
    void getProductBySKU() {
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(product4)).when(productRepo).getProductBySku("SKU17887419");


        assertEquals("Product4", productQuerryImplService.getProductBySKU("SKU17887419").getName());
    }

    @Test
    void getProductBySKUException(){
        doReturn(Optional.empty()).when(productRepo).getProductBySku("SKU17887419");
        assertThrows(ProductNotFoundException.class, () -> productQuerryImplService.getProductBySKU("SKU17887419"));
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
    void getProductsByCategoryException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByCategory("category");
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByCategory("category"));
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
    void getProductsByPriceBetweenException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceBetween(20L, 400L);
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceBetween(20L, 400L));
    }

    @Test
    void getProductsByPriceLessThan() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(500L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(840L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(930L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product4))).when(productRepo).getProductsByPriceLessThan(450L);

        assertEquals(1, productQuerryImplService.getProductsByPriceLessThan(450L).size());

    }

    @Test
    void getProductsByPriceLessThanException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceLessThan(450L);
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceLessThan(450L));
    }

    @Test
    void getProductsByPriceGreaterThan() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product4))).when(productRepo).getProductsByPriceGreaterThan(350L);

        assertEquals(1, productQuerryImplService.getProductsByPriceGreaterThan(350L).size());
    }

    @Test
    void getProductsByPriceGreaterThanException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceGreaterThan(350L);
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceGreaterThan(350L));
    }

    @Test
    void getProductsByPriceLessThanAndCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(500L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(840L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(930L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product4))).when(productRepo).getProductsByPriceLessThanAndCategory(450L, "category1");

        assertEquals(1, productQuerryImplService.getProductsByPriceLessThanAndCategory(450L, "category1").size());

    }

    @Test
    void getProductsByPriceLessThanAndCategoryException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceLessThanAndCategory(450L, "category1");
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceLessThanAndCategory(450L, "category1"));
    }

    @Test
    void getProductsByPriceGreaterThanAndCategory() {



        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category1").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product4))).when(productRepo).getProductsByPriceGreaterThanAndCategory(350L, "category1");

        assertEquals(1, productQuerryImplService.getProductsByPriceGreaterThanAndCategory(350L, "category1").size());


    }

    @Test
    void getProductsByPriceGreaterThanAndCategoryException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceGreaterThanAndCategory(350L, "category1");
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceGreaterThanAndCategory(350L, "category1"));
    }

    @Test
    void getProductsByPriceBetweenAndCategory() {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(90L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category1").price(140L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3 = Product.builder().name("Product3").description("Description3").category("category1").price(320L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4 = Product.builder().name("Product4").description("Description4").category("category1").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product3,product2))).when(productRepo).getProductsByPriceBetweenAndCategory(20L, 400L, "category1");

        assertEquals(2, productQuerryImplService.getProductsByPriceBetweenAndCategory(20L, 400L, "category1").size());

    }

    @Test
    void getProductsByPriceBetweenAndCategoryException(){
        doReturn(Optional.empty()).when(productRepo).getProductsByPriceBetweenAndCategory(20L, 400L, "category1");
        assertThrows(ListEmptyException.class, () -> productQuerryImplService.getProductsByPriceBetweenAndCategory(20L, 400L, "category1"));
    }




}