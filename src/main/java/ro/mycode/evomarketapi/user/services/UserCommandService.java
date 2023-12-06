package ro.mycode.evomarketapi.user.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.user.dto.UserDTO;

@Service
@Transactional
public interface UserCommandService {

    void addUser(UserDTO userDTO);

    void updateUser(String email , UserDTO userDTO);

    void deleteUser(String email);

//    void addOrder()
}
