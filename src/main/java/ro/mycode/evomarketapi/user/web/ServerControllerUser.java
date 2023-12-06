package ro.mycode.evomarketapi.user.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ro.mycode.evomarketapi.system.jwt.JWTTokenProvider;
import ro.mycode.evomarketapi.user.dto.RegisterResponse;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.dto.LoginResponse;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.services.UserCommandServiceImpl;
import ro.mycode.evomarketapi.user.services.UserQuerryServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Slf4j
public class ServerControllerUser {

    private UserCommandServiceImpl userCommandServiceImpl;

    private UserQuerryServiceImpl userQuerryServiceImpl;

    private AuthenticationManager authentificateManager ;

    private JWTTokenProvider jwtTokenProvider;


    private void authenticate(String email, String password) {
        authentificateManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

    private HttpHeaders getJwtHeader(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, jwtTokenProvider.generateJWTToken(user));
        return headers;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDTO userDTO) {
        authenticate(userDTO.email(), userDTO.password());
        User loginUser = userQuerryServiceImpl.findByEmail(userDTO.email()).get();
        HttpHeaders jwtHeader = getJwtHeader(loginUser);
        LoginResponse loginResponse = new LoginResponse(loginUser.getId(), loginUser.getEmail(), jwtHeader.getFirst(HttpHeaders.AUTHORIZATION), loginUser.getFirstName(), loginUser.getLastName(), loginUser.getUserRole());
        return new ResponseEntity<>(loginResponse, jwtHeader, HttpStatus.OK);
    }




    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find/{email}")
    @PreAuthorize("hasAnyRole('ROLE_CLIENT', 'ROLE_ADMIN')")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userQuerryServiceImpl.findByEmail(email).get());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> addUser(@RequestBody UserDTO userDTO) {
        userCommandServiceImpl.addUser(userDTO);
        User user = userQuerryServiceImpl.findByEmail(userDTO.email()).get();
        HttpHeaders jwtHeader = getJwtHeader(user);
        RegisterResponse registerResponse = new RegisterResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), jwtHeader.getFirst(HttpHeaders.AUTHORIZATION));
        return new ResponseEntity<>(registerResponse, jwtHeader, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public ResponseEntity<Boolean> updateUser(@RequestBody String email, @RequestBody UserDTO userDTO) {
        userCommandServiceImpl.updateUser(email, userDTO);
        return ResponseEntity.ok(true);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String email) {
        userCommandServiceImpl.deleteUser(email);
        return ResponseEntity.ok(true);
    }


}
