package ro.mycode.evomarketapi.user.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.mycode.evomarketapi.EvomarketApiApplication;
import ro.mycode.evomarketapi.security.annotations.WithDenisUser;
import ro.mycode.evomarketapi.system.jwt.JWTTokenProvider;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.services.UserCommandServiceImpl;
import ro.mycode.evomarketapi.user.services.UserQuerryServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = EvomarketApiApplication.class)
class ServerControllerUserSecurityTest {

    @Mock
    private UserCommandServiceImpl userCommandServiceImpl;

    @Mock
    private UserQuerryServiceImpl userQuerryServiceImpl;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JWTTokenProvider jwtTokenProvider;

    @InjectMocks
    private ServerControllerUser serverControllerUser;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public User convertUserDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setPhoneNumber(userDTO.phoneNumber());
        user.setRegisteredAt(LocalDateTime.now());
        user.setActive(userDTO.active());
        user.setUserRole(UserRole.CLIENT);
        return user;
    }


    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(serverControllerUser).setMessageConverters(
                new MappingJackson2HttpMessageConverter(objectMapper)
        ).build();

    }

//    @Test
//    @WithDenisUser
//    void findByEmail() throws Exception
//    {
////        User user=new User();
////        user.setFirstName("Denis");
////        user.setLastName("Flore");
////        user.setEmail("floredenis907@yahoo.com");
////        user.setPassword("");
////        user.setPhoneNumber("0773941000");
////        user.setUserRole(UserRole.CLIENT);
////        user.setRegisteredAt(LocalDateTime.now());
////        user.setActive(true);
//        UserDTO user = UserDTO.builder().email("floredenis907@yahoo.com").build();
//        when(this.userQuerryServiceImpl.findByEmail(user.email())).thenReturn(Optional.of(convertUserDTOtoUser(user)));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/v1/user/find/floredenis907@yahoo.com").
//                accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
//                andExpect(content().string(objectMapper.writeValueAsString(user)));
//
//
//    }
}