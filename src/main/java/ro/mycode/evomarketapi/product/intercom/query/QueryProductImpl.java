package ro.mycode.evomarketapi.product.intercom.query;

import org.springframework.http.ResponseEntity;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;

public class QueryProductImpl implements QueryProduct {

    private QueryProduct queryProduct;

    public QueryProductImpl(QueryProduct queryProduct) {
        this.queryProduct = queryProduct;
    }


    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> products = queryProduct.getAllProducts();
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        ResponseEntity<Product> product = queryProduct.getProductById(id);
        if (product.getBody() == null) {
            throw new ListEmptyException();
        } else {
            return product;
        }
    }

    @Override
    public ResponseEntity<Product> getProductBySKU(String sku) {

        ResponseEntity<Product> product = queryProduct.getProductBySKU(sku);
        if (product.getBody() == null) {
            throw new ListEmptyException();
        } else {
            return product;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByCategory(String category) {

        ResponseEntity<List<Product>> product = queryProduct.getProductsByCategory(category);
        if (product.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return product;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceBetween(Long min, Long max) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceBetween(min, max);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceLessThan(Long max) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceLessThan(max);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }

    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(Long min) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceGreaterThan(min);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategory(Long max, String category) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceLessThanAndCategory(max, category);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategory(Long min, String category) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceGreaterThanAndCategory(min, category);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }

    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategory(Long min, Long max, String category) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceBetweenAndCategory(min, max, category);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategoryAndName(Long max, String category, String name) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceLessThanAndCategoryAndName(max, category, name);

        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }

    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategoryAndName(Long min, String category, String name) {

        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceGreaterThanAndCategoryAndName(min, category, name);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategoryAndName(Long min, Long max, String category, String name) {


        ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceBetweenAndCategoryAndName(min, max, category, name);
        if (products.getBody().isEmpty()) {
            throw new ListEmptyException();
        } else {
            return products;
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndName(Long max, String name) {

            ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceLessThanAndName(max, name);
            if (products.getBody().isEmpty()) {
                throw new ListEmptyException();
            } else {
                return products;
            }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndName(Long min, String name) {

            ResponseEntity<List<Product>> products = queryProduct.getProductsByPriceGreaterThanAndName(min, name);
            if (products.getBody().isEmpty()) {
                throw new ListEmptyException();
            } else {
                return products;
            }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndName(Long min, Long max, String name) {
        return null;
    }
}
