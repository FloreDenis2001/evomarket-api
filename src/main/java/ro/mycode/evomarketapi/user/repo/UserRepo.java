package ro.mycode.evomarketapi.user.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.evomarketapi.user.models.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

//        @EntityGraph(attributePaths = {"orderSet"}, type = EntityGraph.EntityGraphType.LOAD)
//        Optional<List<User>> getAll();
//
        @EntityGraph(attributePaths = {"orderSet"}, type = EntityGraph.EntityGraphType.LOAD)
        Optional<User> findByEmail(String email);
//
//        @EntityGraph(attributePaths = {"orderSet"}, type = EntityGraph.EntityGraphType.LOAD)
//        Optional<User> findByUsername(String username);

}
