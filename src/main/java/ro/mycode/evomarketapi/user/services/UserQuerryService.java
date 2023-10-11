package ro.mycode.evomarketapi.user.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.user.models.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface UserQuerryService {


    Optional<User> findByEmail(String email);




}
