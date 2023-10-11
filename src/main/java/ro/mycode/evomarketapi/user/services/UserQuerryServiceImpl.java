package ro.mycode.evomarketapi.user.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserQuerryServiceImpl implements UserQuerryService {

    UserRepo userRepo;


    public UserQuerryServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return user;
        } else {
            throw new ListEmptyException();
        }
    }


}
