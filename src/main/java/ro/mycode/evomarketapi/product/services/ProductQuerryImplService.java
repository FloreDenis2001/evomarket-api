package ro.mycode.evomarketapi.product.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.repo.ProductRepo;

import java.util.List;

@Service
public class ProductQuerryImplService implements ProductQuerryService {

    private final ProductRepo productRepo;

    public ProductQuerryImplService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.getAllProducts();
        if (products.isEmpty()) {
            throw new ListEmptyException();
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepo.getProductsById(id).orElseThrow(()-> new ListEmptyException());
        return product;
    }

    @Override
    public Product getProductBySKU(String SKU) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceBetween(Long min, Long max) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceLessThan(Long max) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(Long min) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceLessThanAndCategory(Long max, String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThanAndCategory(Long min, String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceBetweenAndCategory(Long min, Long max, String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceLessThanAndName(Long max, String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceGreaterThanAndName(Long min, String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByPriceBetweenAndName(Long min, Long max, String name) {
        return null;
    }
}
