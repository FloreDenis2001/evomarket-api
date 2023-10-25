package ro.mycode.evomarketapi.orderdetails.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/server/api-docs/oraderdetails")

public class DocApiControllerOrderDetails {


    @GetMapping("/id")
    @Operation(summary = "Returnează toate orderDetails-ul dupa id")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String findById() {
        return "Returneaza orderDetails-ul dupa id";
    }

    @GetMapping("/sku")
    @Operation(summary = "Returnează toate orderDetails-urile dupa sku")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String findBySKU() {
        return "Returneaza orderDetails-uril dupa sku";
    }


    @GetMapping("/order-id")
    @Operation(summary = "Returnează toate orderDetails-ul dupa order-id")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String findByOrderId() {
        return "Returneaza orderDetails-ul dupa order-id";
    }

    @PostMapping("/add")
    @Operation(summary = "Adauga un orderDetails nou")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String addOrderDetails() {
        return "Adauga un orderDetails nou";
    }


    @PutMapping("/update")
    @Operation(summary = "Actualizeaza un orderDetails existent")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String updateOrderDetails() {
        return "Actualizeaza un orderDetails existent";
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Sterge un orderDetails existent")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String deleteOrderDetails() {
        return "Sterge un orderDetails existent";
    }





}
