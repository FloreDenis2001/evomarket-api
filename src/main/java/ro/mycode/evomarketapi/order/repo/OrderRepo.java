package ro.mycode.evomarketapi.order.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.order.models.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {


    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Order> findById(Long id);

    @EntityGraph(attributePaths = {"orderDetailsSet"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Order> findAll();

//    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
//    List<Order> findAllByUserId(Long userId);
//
//    @EntityGraph( type = EntityGraph.EntityGraphType.LOAD)
//    List<Order> findAllByUserIdAndStatus(Long userId, String status);
//
//    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
//    List<Order> findAllByStatus(String status);

}
