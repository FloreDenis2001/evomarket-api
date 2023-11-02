package ro.mycode.evomarketapi.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;
import ro.mycode.evomarketapi.user.services.UserCommandServiceImpl;
import ro.mycode.evomarketapi.user.services.UserQuerryServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
@Slf4j
public class ServerControllerUser {

    private UserCommandServiceImpl userCommandServiceImpl;

    private UserQuerryServiceImpl userQuerryServiceImpl;

    public ServerControllerUser(UserCommandServiceImpl userCommandServiceImpl, UserQuerryServiceImpl userQuerryServiceImpl) {
        this.userCommandServiceImpl = userCommandServiceImpl;
        this.userQuerryServiceImpl = userQuerryServiceImpl;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find/{email}")
    @PreAuthorize("hasAnyRole('ROLE_CLIENT', 'ROLE_ADMIN')")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userQuerryServiceImpl.findByEmail(email).get());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/add")
    public ResponseEntity<Boolean> addUser(@RequestBody UserDTO userDTO) {
        userCommandServiceImpl.addUser(userDTO);
        return ResponseEntity.ok(true);
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
