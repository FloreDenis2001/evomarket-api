package ro.mycode.evomarketapi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EvomarketApiApplication.class)
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {

        userRepo.deleteAll();

    }

    @Test
    void findByEmail() {

        User user=new User();
                    user.setFirstName("Andrei");
                    user.setLastName("Popescu");
                    user.setEmail("andreipopescu@yahoo.com");
                    user.setPassword("andrei1234");
                    user.setPhoneNumber("0722222222");
                    user.setUserRole(UserRole.ADMIN);
                    user.setRegisteredAt(LocalDateTime.now());
                    user.setCreatedAt(LocalDateTime.now());
                    user.setActive(true);

                    userRepo.saveAndFlush(user);

          assertEquals(true,userRepo.findByEmail("andreipopescu@yahoo.com").get().isActive());
    }
}