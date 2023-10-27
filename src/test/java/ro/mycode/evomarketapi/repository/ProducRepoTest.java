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
import java.util.List;

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
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);

        Product p3=productRepo.findById(product1.getId()).get();
        assertEquals("Product1", p3.getName());


    }



    @Test
    void getProductByCategoryTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);
        List<Product> listOfProducts=productRepo.getProductsByCategory("category").get();
        assertEquals(1,listOfProducts.size());

    }

    @Test
    void getProductByPriceBetweenTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        productRepo.saveAndFlush(product1);
        List<Product> listOfProducts=productRepo.getProductsByPriceBetween(50L,150L).get();
        assertEquals(true,listOfProducts.contains(product1));
    }

    @Test
    void getProductByPriceLessThanTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);
        List<Product> list=productRepo.getProductsByPriceLessThan(150L).get();
        assertEquals(3,list.size());
    }

    @Test
    void getProductByPriceGreaterThanTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThan(50L).get();
        assertEquals(2,list.size());
    }

    @Test
    void getProductByPriceLessThanAndCategoryTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndCategory(150L,"category1").get();
        assertEquals(2,list.size());
    }


    @Test
    void getProductByPriceGreaterThanAndCategoryTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndCategory(50L,"category1").get();
        assertEquals(1,list.size());
    }


    @Test
    void getProductByPriceBetweenAndCategoryTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceBetweenAndCategory(50L,150L,"category1").get();
        assertEquals(1,list.size());
    }


    @Test
    void getProductByPriceLessThanAndCategoryAndNameTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndCategoryAndName(150L,"category1","Product1").get();
        assertEquals(1,list.size());
    }

    @Test
    void getProductByPriceGreaterThanAndCategoryAndNameTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndCategoryAndName(50L,"category1","Product1").get();
        assertEquals(1,list.size());
    }


    @Test
    void getProductByPriceBetweenAndCategoryAndNameTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceBetweenAndCategoryAndName(50L,150L,"category1","Product1").get();
        assertEquals(1,list.size());
    }

    @Test
    void getProductByPriceLessThanAndNameTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndName(150L,"Product1").get();
        assertEquals(1,list.size());
    }

    @Test
    void getProductByPriceGreaterThanAndNameTest(){
        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndName(50L,"Product1").get();
        assertEquals(1,list.size());
    }

   @Test
    void getProductByPriceBetweenAndNameTest(){

       Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
       Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
       Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
       Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

       List<Product> listOfProducts = List.of(product1,product2,product3,product4);
       productRepo.saveAllAndFlush(listOfProducts);

       List<Product> list=productRepo.getProductsByPriceBetweenAndName(50L,150L,"Product1").get();
       assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceBetweenAndCategoryAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceBetweenAndCategoryAndName(50L,150L,"category1","Product1").get();
        assertEquals(1,list.size());

    }


    @Test
    void getProductByPriceLessThanAndCategoryAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndCategoryAndName(150L,"category1","Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceGreaterThanAndCategoryAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndCategoryAndName(50L,"category1","Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceLessThanAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndName(150L,"Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceGreaterThanAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4)
                .build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417").createdDate(LocalDateTime.now())
                .quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418").createdDate(LocalDateTime.now())
                .quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419").createdDate(LocalDateTime.now())
                .quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);
        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndName(50L,"Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceBetweenAndNameTest2(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);

        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceBetweenAndName(50L,150L,"Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceLessThanAndCategoryAndNameTest3(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);

        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceLessThanAndCategoryAndName(150L,"category1","Product1").get();
        assertEquals(1,list.size());

    }

    @Test
    void getProductByPriceGreaterThanAndCategoryAndNameTest3(){

        Product product1 = Product.builder().name("Product1").description("Description1").category("category1").price(100L).SKU("SKU17887416")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2=Product.builder().name("Product2").description("Description2").category("category2").price(40L).SKU("SKU17887417")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product3=Product.builder().name("Product3").description("Description3").category("category1").price(30L).SKU("SKU17887418")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product4=Product.builder().name("Product4").description("Description4").category("category2").price(400L).SKU("SKU17887419")
                .createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        List<Product> listOfProducts = List.of(product1,product2,product3,product4);

        productRepo.saveAllAndFlush(listOfProducts);

        List<Product> list=productRepo.getProductsByPriceGreaterThanAndCategoryAndName(50L,"category1","Product1").get();
        assertEquals(1,list.size());

    }
}
