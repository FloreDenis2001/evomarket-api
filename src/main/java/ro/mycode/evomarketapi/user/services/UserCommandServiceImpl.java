package ro.mycode.evomarketapi.user.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.UserAlreadyExistsException;
import ro.mycode.evomarketapi.exceptions.UserNotFound;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;

import java.util.Optional;

@Service
@Transactional
public class UserCommandServiceImpl implements UserCommandService {

    UserRepo userRepo;

    public UserCommandServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void addUser(UserDTO userDTO) {

        Optional<User> user = userRepo.findByEmail(userDTO.email());
        if (user.isEmpty()) {
            User x = new User();
            x.setEmail(userDTO.email());
            x.setFirstName(userDTO.firstName());
            x.setLastName(userDTO.lastName());
            x.setPhoneNumber(userDTO.phoneNumber());
            x.setPassword(userDTO.password());
            x.setFirstName(userDTO.firstName());
            x.setLastName(userDTO.lastName());
            x.setRegisteredAt(userDTO.registeredAt());
            x.setCreatedAt(userDTO.createdAt());
            x.setActive(userDTO.active());
            x.setUserRole(UserRole.CLIENT);
            userRepo.save(x);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public void updateUser(String email , UserDTO userDTO) {

        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            User x = user.get();
            x.setEmail(userDTO.email());
            x.setFirstName(userDTO.firstName());
            x.setLastName(userDTO.lastName());
            x.setPhoneNumber(userDTO.phoneNumber());
            x.setPassword(userDTO.password());
            userRepo.save(x);
        } else {
            throw new UserNotFound();
        }

    }

    @Override
    public void deleteUser(String email) {

        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            userRepo.delete(user.get());
        } else {
            throw new UserNotFound();
        }

    }
}
