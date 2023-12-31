package ro.mycode.evomarketapi.product.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductQuerryImplService implements ProductQuerryService {

    private final ProductRepo productRepo;

    public ProductQuerryImplService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTOList=new ArrayList<>();
        for (  Product product:products) {
            productDTOList.add(ProductDTO.fromProduct(product));
        }
        if (productDTOList.isEmpty()) {
            throw new ListEmptyException();
        }
        return productDTOList;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }else {
            return   product.get();
        }
    }


    @Override
    public Product getProductBySKU(String SKU) {
        Product product = productRepo.getProductBySku(SKU).orElseThrow(() -> new ProductNotFoundException());
        return product;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> product = productRepo.getProductsByCategory(category).orElseThrow(() -> new ListEmptyException());
        return product;
    }



    @Override
    public List<Product> getProductsByPriceBetween(Long min, Long max) {

        List<Product> products = productRepo.getProductsByPriceBetween(min, max).orElseThrow(() -> new ListEmptyException());
        return products;
    }

    @Override
    public List<Product> getProductsByPriceLessThan(Long max) {

        List<Product> products = productRepo.getProductsByPriceLessThan(max).orElseThrow(() -> new ListEmptyException());
        return products;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(Long min) {
        List<Product> products = productRepo.getProductsByPriceGreaterThan(min).orElseThrow(() -> new ListEmptyException());
        return products;
    }

    @Override
    public List<Product> getProductsByPriceLessThanAndCategory(Long max, String category) {
        List<Product> products = productRepo.getProductsByPriceLessThanAndCategory(max, category).orElseThrow(() -> new ListEmptyException());
        return products;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThanAndCategory(Long min, String category) {
        List<Product> products = productRepo.getProductsByPriceGreaterThanAndCategory(min, category).orElseThrow(() -> new ListEmptyException());
        return products;
    }

    @Override
    public List<Product> getProductsByPriceBetweenAndCategory(Long min, Long max, String category) {

        List<Product> products = productRepo.getProductsByPriceBetweenAndCategory(min, max, category).orElseThrow(() -> new ListEmptyException());
        return products;
    }


}
