package ro.mycode.evomarketapi.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.ProductAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.utils.Mapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductCommandImplServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductCommandServiceImpl productCommandService;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;

    private Mapper mapper = new Mapper();



    @Test
    public void addProductTest() {
        ProductDTO productDTO=ProductDTO.builder().name("ProductDTO").description("Description1").category("category").price(100L).SKU("SK94142135").quantity(59).weight(4).build();
        productCommandService.addProduct(productDTO);
        doReturn(Optional.of(mapper.covertProductDTOtoProduct(productDTO))).when(productRepo).getProductBySku("SK94142135");
        assertEquals("ProductDTO", productRepo.getProductBySku("SK94142135").get().getName());
    }

    @Test
    public void addProductException(){
        ProductDTO productDTO=ProductDTO.builder().name("ProductDTO").description("Description1").category("category").price(100L).SKU("SK94142135").quantity(59).weight(4).build();
        doReturn(Optional.of(mapper.covertProductDTOtoProduct(productDTO))).when(productRepo).getProductBySku("SK94142135");
        assertThrows(ProductAlreadyExistException.class, () -> productCommandService.addProduct(productDTO));
    }

    @Test
    public void removeTest(){
        ProductDTO productDTO=ProductDTO.builder().name("ProductDTO").description("Description1").category("category").price(100L).SKU("SK94142135").quantity(59).weight(4).build();
        doReturn(Optional.of(mapper.covertProductDTOtoProduct(productDTO))).when(productRepo).getProductBySku("SK94142135");
        productCommandService.deleteProduct("SK94142135");
        verify(productRepo, times(1)).delete(productArgumentCaptor.capture());
        assertEquals("SK94142135", productArgumentCaptor.getValue().getSku());
    }

    @Test
    public void removeTestException(){
        doReturn(Optional.empty()).when(productRepo).getProductBySku("SK94142135");
        assertThrows(ProductNotFoundException.class, () -> productCommandService.deleteProduct("SK94142135"));
    }

//
//    @Test
//    public void updateTest(){
//        UpdateProductRequest updateProductRequest = UpdateProductRequest.builder().name("ProductUpdate2").description("DescriptionUpdate").category("category").price(110L).quantity(59).weight(4).build();
//        Product product1 = Product.builder().name("Product1").description("Description1").category("category").price(100L).SKU("SKU17887416").createdDate(LocalDateTime.now()).quantity(59).weight(4).build();
//        doReturn(Optional.of(product1)).when(productRepo).getProductBySKU("SKU17887416");
//        productCommandService.updateProduct("SKU17887416", updateProductRequest);
//        verify(productRepo, times(1)).save(productArgumentCaptor.capture());
//        assertEquals("DescriptionUpdate", productArgumentCaptor.getValue().getDescription());
//    }


//    @Test
//    public void updateTestException(){
//        UpdateProductRequest updateProductRequest = UpdateProductRequest.builder().name("ProductUpdate2").description("DescriptionUpdate").category("category").price(110L).quantity(59).weight(4).build();
//        doReturn(Optional.empty()).when(productRepo).getProductBySKU("SKU17887416");
//        assertThrows(ProductNotFoundException.class, () -> productCommandService.updateProduct("SKU17887416", updateProductRequest));
//    }


}
