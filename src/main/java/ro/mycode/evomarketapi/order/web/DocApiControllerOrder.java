package ro.mycode.evomarketapi.order.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/server/api-docs/order")
public class DocApiControllerOrder {



    @GetMapping("/all/{userId}")
    @Operation(summary = "Returnează toate comenzile unui user")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String getAllOrdersByUserId() {
        return "Returnează toate comenzile unui user";
    }


    @GetMapping("/id/{id}")
    @Operation(summary = "Returnează comanda cu id-ul specificat")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String getOrderById() {
        return "Returnează comanda cu id-ul specificat";
    }

    @PostMapping("/add")
    @Operation(summary = "Adauga o comanda noua")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String addOrder() {
        return "Adauga o comanda noua";
    }


    @PutMapping("/update")
    @Operation(summary = "Actualizeaza o comanda existenta")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String updateOrder() {
        return "Actualizeaza o comanda existenta";
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Sterge o comanda existenta")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String deleteOrder() {
        return "Sterge o comanda existenta";
    }
}
