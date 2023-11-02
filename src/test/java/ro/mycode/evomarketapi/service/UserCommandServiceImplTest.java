package ro.mycode.evomarketapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.evomarketapi.exceptions.UserAlreadyExistsException;
import ro.mycode.evomarketapi.exceptions.UserNotFound;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.system.utils.Mapper;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.repo.UserRepo;
import ro.mycode.evomarketapi.user.services.UserCommandServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserCommandServiceImplTest {


    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserCommandServiceImpl userCommandService;

    @Captor
    ArgumentCaptor<User> userArgumentCaptor;

    Mapper mapper = new Mapper();

    @Test
    void addUser() {
        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denisupdate@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();

        userCommandService.addUser(userDTO);

        doReturn(Optional.of(mapper.convertUserDTOtoUser(userDTO))).when(userRepo).findByEmail("denisupdate@yahoo.com");

        assertEquals("Denis", userRepo.findByEmail("denisupdate@yahoo.com").get().getFirstName());

    }

    @Test
    void addUserException() {
        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denisupdate@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        doReturn(Optional.of(mapper.convertUserDTOtoUser(userDTO))).when(userRepo).findByEmail("denisupdate@yahoo.com");
        assertThrows(UserAlreadyExistsException.class, () -> userCommandService.addUser(userDTO));
    }

    @Test
    void updateUser() {

        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denis@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        UserDTO userDTO2 = UserDTO.builder().firstName("Denis").lastName("Flore").email("denis@yahoo.com").password("denisupdate1234").phoneNumber("0711111111").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        doReturn(Optional.of(mapper.convertUserDTOtoUser(userDTO))).when(userRepo).findByEmail(userDTO.email());
        userCommandService.updateUser(userDTO.email(), userDTO2);
        assertEquals("0711111111", userRepo.findByEmail(userDTO.email()).get().getPhoneNumber());

    }

    @Test
    void updateUserException() {
        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denis@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        doReturn(Optional.empty()).when(userRepo).findByEmail(userDTO.email());
        assertThrows(UserNotFound.class, () -> userCommandService.updateUser(userDTO.email(), userDTO));
    }

    @Test
    void deleteUser() {
        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denis@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        doReturn(Optional.of(mapper.convertUserDTOtoUser(userDTO))).when(userRepo).findByEmail(userDTO.email());
        userCommandService.deleteUser(userDTO.email());
        verify(userRepo).delete(userArgumentCaptor.capture());
        assertEquals("Denis", userArgumentCaptor.getValue().getFirstName());

    }

    @Test
    void deleteUserException() {
        UserDTO userDTO = UserDTO.builder().firstName("Denis").lastName("Flore").email("denis@yahoo.com").password("denis1234").phoneNumber("0722222222").userRole(UserRole.ADMIN).registeredAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).active(true).build();
        doReturn(Optional.empty()).when(userRepo).findByEmail(userDTO.email());
        assertThrows(UserNotFound.class, () -> userCommandService.deleteUser(userDTO.email()));
    }
}