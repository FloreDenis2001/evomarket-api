package ro.mycode.evomarketapi.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;
import ro.mycode.evomarketapi.product.web.ServerControllerProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = EvomarketApiApplication.class)
class ServerControllerProductITTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ServerControllerProduct serverControllerProduct;

    @Autowired
    private ProductCommandServiceImpl productCommandService;

    @Autowired
    private ProductQuerryImplService productQuerryImplService;

    @MockBean
    private ProductRepo productRepo;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @Test
    void getAllProducts() throws Exception {

        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product5 = Product.builder().name("Product5").description("Description5").category("category").price(100L).SKU("SKU14428876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product6 = Product.builder().name("Product6").description("Description6").category("category").price(100L).SKU("SKU17519776").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product11 = Product.builder().name("Product11").description("Description1").category("category").price(100L).SKU("SKU4000116").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(List.of(product1, product2, product3, product4, product5, product6, product11)).when(productRepo).findAll();

        mockMvc
                .perform(get("/api/v1/product/all")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(7))).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4, product5, product6, product11))));


    }

    @Test
    void getProductById() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(Optional.of(product1)).when(productRepo).findById(1L);
        mockMvc.perform(get("/api/v1/product/id/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(product1)));

    }

    @Test
    void getProductBySKU() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(Optional.of(product1)).when(productRepo).getProductBySKU("SKU17887416");
        mockMvc.perform(get("/api/v1/product/sku/SKU17887416")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(product1)));


    }

    @Test
    void getProductsByCategory() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByCategory("category");
        mockMvc.perform(get("/api/v1/product/category/category")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));

    }

    @Test
    void getProductsByPriceBetween() throws Exception {


        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(70L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product3, product4))).when(productRepo).getProductsByPriceBetween(60L, 100L);
        mockMvc.perform(get("/api/v1/product/price/between/60/100")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product3, product4))));

    }

    @Test
    void getProductsByPriceLessThan() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByPriceLessThan(100L);
        mockMvc.perform(get("/api/v1/product/price/lessThan/100")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));

    }

    @Test
    void getProductsByPriceGreaterThan() throws Exception {

        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByPriceGreaterThan(60L);
        mockMvc.perform(get("/api/v1/product/price/greaterThan/60")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));

    }

    @Test
    void getProductsByPriceLessThanAndCategory() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByPriceLessThanAndCategory(100L, "category");
        mockMvc.perform(get("/api/v1/product/price/lessThan/100/category/category")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));

    }

    @Test
    void getProductsByPriceGreaterThanAndCategory() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByPriceGreaterThanAndCategory(60L, "category");
        mockMvc.perform(get("/api/v1/product/price/greaterThan/60/category/category")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));


    }

    @Test
    void getProductsByPriceBetweenAndCategory() throws Exception {
        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        Product product2 = Product.builder().name("Product2").description("Description2").category("category").price(100L).SKU("SKU17738876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product3 = Product.builder().name("Product3").description("Description3").category("category").price(100L).SKU("SKU17812876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        Product product4 = Product.builder().name("Product4").description("Description4").category("category").price(100L).SKU("SKU17890876").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();


        doReturn(Optional.of(List.of(product1, product2, product3, product4))).when(productRepo).getProductsByPriceBetweenAndCategory(60L, 100L, "category");
        mockMvc.perform(get("/api/v1/product/price/between/60/100/category/category")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(List.of(product1, product2, product3, product4))));

    }

    @Test
    void addProduct() throws Exception {
        ProductDTO productDTO = ProductDTO.builder().name("ProductDTO").description("Description1").category("category").price(100L).SKU("SK94142135").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
        doReturn(Optional.empty()).when(productRepo).getProductBySKU("SKU17887416");
        mockMvc.perform(post("/api/v1/product/add")
                        .contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsBytes(productDTO)))
                .andExpect(status().isCreated())
        ;
    }

    @Test
    void updateProduct() throws Exception {
        UpdateProductRequest updateProductRequest = UpdateProductRequest.builder().name("ProductUpdate2").description("Description1").category("category").price(110L).quantity(59).weight(4).build();


        Product existingProduct = new Product();
        existingProduct.setId(1L);
        existingProduct.setName("Product1");
        existingProduct.setDescription("Description1");
        existingProduct.setCategory("category");
        existingProduct.setPrice(100L);
        existingProduct.setSKU("SKU17887416");
        existingProduct.setCreatedDate(LocalDateTime.now());
        existingProduct.setQuantity(59);
        existingProduct.setWeight(4);

        doReturn(Optional.of(existingProduct)).when(productRepo).getProductBySKU("SKU17887416");

        mockMvc.perform(put("/api/v1/product/update/SKU17887416")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(updateProductRequest)))
                .andExpect(status().isAccepted());


    }

    @Test
    void deleteProduct()  throws Exception{

        Product product1 = Product.builder().id(1L).name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();

        doReturn(Optional.of(product1)).when(productRepo).getProductBySKU("SKU17887416");

        mockMvc.perform(delete("/api/v1/product/delete/SKU17887416")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}