package ro.mycode.evomarketapi.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.product.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {



}
