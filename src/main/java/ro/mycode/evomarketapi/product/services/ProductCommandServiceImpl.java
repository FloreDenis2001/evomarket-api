package ro.mycode.evomarketapi.product.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ProductAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.utils.SKUGenerator;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Transactional
public class ProductCommandServiceImpl implements ProductCommandService {


    private ProductRepo productRepo;

    public ProductCommandServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public void addProduct(ProductDTO productDTO) {
        Optional<Product> productOptional = productRepo.getProductBySku(productDTO.getSKU());
        if (productOptional.isEmpty()) {
            Product product=Product.builder().name(productDTO.getName()).description(productDTO.getDescription()).category(productDTO.getCategory()).price(productDTO.getPrice()).sku(SKUGenerator.generateUniqueSKU()).quantity(productDTO.getQuantity()).weight(productDTO.getWeight()).rating(0).createdDate(LocalDateTime.now()).build();
            productRepo.save(product);
        } else {
            throw new ProductAlreadyExistException();
        }
    }

    @Override
    public void updateProduct(UpdateProductRequest updateProductRequest){
        Optional<Product> productOptional = productRepo.getProductBySku(updateProductRequest.sku());
        if (productOptional.isPresent()) {

            Product product = productOptional.get();

            if(updateProductRequest.name() != null){
                product.setName(updateProductRequest.name());
            }
            if(updateProductRequest.description() != null){
                product.setDescription(updateProductRequest.description());
            }
            if(updateProductRequest.price() != null){
                product.setPrice(updateProductRequest.price());
            }
            if(updateProductRequest.quantity() != 0){
                product.setQuantity(updateProductRequest.quantity());
            }
            if(updateProductRequest.weight() != 0){
                product.setWeight(updateProductRequest.weight());
            }
            if(updateProductRequest.category() != null){
                product.setCategory(updateProductRequest.category());
            }
            productRepo.save(product);

        } else {
            throw new ProductNotFoundException();
        }


    }

    @Override
    public void deleteProduct(String SKU) {

        Optional<Product> productOptional = productRepo.getProductBySku(SKU);
        if (productOptional.isPresent()) {
            productRepo.delete(productOptional.get());
        } else {
            throw new ProductNotFoundException();
        }

    }
}
