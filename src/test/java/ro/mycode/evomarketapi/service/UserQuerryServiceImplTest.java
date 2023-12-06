package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.UserNotFound;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;
import ro.mycode.evomarketapi.user.services.UserQuerryServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserQuerryServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserQuerryServiceImpl userQuerryServiceImpl;

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
                    user.setActive(true);

        doReturn(Optional.of(user)).when(userRepo).findByEmail("andreipopescu@yahoo.com");

        assertEquals("Andrei", userQuerryServiceImpl.findByEmail("andreipopescu@yahoo.com").get().getFirstName());

    }

    @Test
    void findByEmailException() {
        doReturn(Optional.empty()).when(userRepo).findByEmail("andreipopescu@yahoo.com");
        assertThrows(UserNotFound.class, () -> userQuerryServiceImpl.findByEmail("andreipopescu@yahoo.com"));

    }
}