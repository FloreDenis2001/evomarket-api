package ro.mycode.evomarketapi.product.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ProductAlreadyExistException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;

import java.util.Optional;


@Service
public class ProductCommandServiceImpl implements ProductCommandService {


    private ProductRepo productRepo;

    public ProductCommandServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public void addProduct(ProductDTO productDTO) {
        Optional<Product> productOptional = productRepo.getProductBySKU(productDTO.SKU());
        if (productOptional.isEmpty()) {
            Product product = new Product(productDTO.name(), productDTO.description(), productDTO.price(), productDTO.SKU(), productDTO.quantity(), productDTO.weight(), productDTO.category(), productDTO.rating(), productDTO.createdDate());
            productRepo.save(product);
        } else {
            throw new ProductAlreadyExistException();
        }
    }

    @Override
    public void updateProduct(String SKU, UpdateProductRequest updateProductRequest){
        Optional<Product> productOptional = productRepo.getProductBySKU(SKU);
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

        Optional<Product> productOptional = productRepo.getProductBySKU(SKU);
        if (productOptional.isPresent()) {
            productRepo.delete(productOptional.get());
        } else {
            throw new ProductNotFoundException();
        }

    }
}
