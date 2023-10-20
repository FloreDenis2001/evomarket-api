package ro.mycode.evomarketapi.product.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.exceptions.ProductNotFoundException;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;
import ro.mycode.evomarketapi.product.services.ProductQuerryImplService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
@Slf4j
public class ServerControllerProduct {

    private ProductQuerryImplService productQuerryImplService;
    private ProductCommandServiceImpl productCommandServiceImpl;


    public ServerControllerProduct(ProductQuerryImplService productQuerryImplService, ProductCommandServiceImpl productCommandServiceImpl) {
        this.productQuerryImplService = productQuerryImplService;
        this.productCommandServiceImpl = productCommandServiceImpl;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        Optional<List<Product>> products = Optional.of(productQuerryImplService.getAllProducts());
        if (products.isEmpty()) {
            throw new ListEmptyException();
        } else {
            return ResponseEntity.ok(products.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = Optional.of(productQuerryImplService.getProductById(id));
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        } else {
            return ResponseEntity.ok(product.get());
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sku/{sku}")
    public ResponseEntity<Product> getProductBySKU(@PathVariable String sku) {
        Optional<Product> product = Optional.of(productQuerryImplService.getProductBySKU(sku));
        if (product.isEmpty()) {
            throw new ProductNotFoundException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByCategory(category));
        if (product.isEmpty()) {
            throw new ProductNotFoundException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/between/{min}/{max}")
    public ResponseEntity<List<Product>> getProductsByPriceBetween(@PathVariable Long min, @PathVariable Long max) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceBetween(min, max));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/lessThan/{max}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThan(@PathVariable Long max) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceLessThan(max));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/greaterThan/{min}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@PathVariable Long min) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceGreaterThan(min));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/lessThan/{max}/category/{category}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategory(@PathVariable Long max, @PathVariable String category) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceLessThanAndCategory(max, category));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/greaterThan/{min}/category/{category}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategory(@PathVariable Long min, @PathVariable String category) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceGreaterThanAndCategory(min, category));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/between/{min}/{max}/category/{category}")
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategory(@PathVariable Long min, @PathVariable Long max, @PathVariable String category) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceBetweenAndCategory(min, max, category));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/lessThan/{max}/category/{category}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndCategoryAndName(@PathVariable Long max, @PathVariable String category, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceLessThanAndCategoryAndName(max, category, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/greaterThan/{min}/category/{category}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndCategoryAndName(@PathVariable Long min, @PathVariable String category, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceGreaterThanAndCategoryAndName(min, category, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/between/{min}/{max}/category/{category}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndCategoryAndName(@PathVariable Long min, @PathVariable Long max, @PathVariable String category, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceBetweenAndCategoryAndName(min, max, category, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/lessThan/{max}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThanAndName(@PathVariable Long max, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceLessThanAndName(max, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/greaterThan/{min}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThanAndName(@PathVariable Long min, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceGreaterThanAndName(min, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price/between/{min}/{max}/name/{name}")
    public ResponseEntity<List<Product>> getProductsByPriceBetweenAndName(@PathVariable Long min, @PathVariable Long max, @PathVariable String name) {
        Optional<List<Product>> product = Optional.of(productQuerryImplService.getProductsByPriceBetweenAndName(min, max, name));
        if (product.isEmpty()) {
            throw new ListEmptyException();

        } else {
            return ResponseEntity.ok(product.get());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        productCommandServiceImpl.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateProductRequest> updateProduct(@RequestBody String SKU,@RequestBody UpdateProductRequest updateProductRequest) {
        productCommandServiceImpl.updateProduct(SKU,updateProductRequest);
        return new ResponseEntity<>(updateProductRequest,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{SKU}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String SKU) {
        Product product = productQuerryImplService.getProductBySKU(SKU);
        productCommandServiceImpl.deleteProduct(SKU);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
