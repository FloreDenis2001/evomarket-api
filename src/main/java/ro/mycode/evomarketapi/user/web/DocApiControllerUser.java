package ro.mycode.evomarketapi.user.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/server/api-doc/user")
public class DocApiControllerUser {

    @GetMapping("/find/{email}")
    @Operation(summary = "Returnează true dacă există un user cu email-ul specificat")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String findByEmail() {
        return "Returnează true dacă există un user cu email-ul specificat";
    }

    @PostMapping("/add")
    @Operation(summary = "Adaugă un user nou")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String addUser() {
        return "Adaugă un user nou";
    }

    @PutMapping("/update")
    @Operation(summary = "Actualizează un user existent")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String updateUser() {
        return "Actualizează un user existent";
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Șterge un user existent")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String deleteUser() {
        return "Șterge un user existent";
    }
}
