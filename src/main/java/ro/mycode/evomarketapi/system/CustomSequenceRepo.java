package ro.mycode.evomarketapi.system;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomSequenceRepo extends JpaRepository<CustomSequence, Long> {

    CustomSequence findByName(String name);
}
