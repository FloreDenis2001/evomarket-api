package ro.mycode.evomarketapi.product.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/server/api-docs/product")
public class DocApiControllerProduct {

    @GetMapping("/all")
    @Operation(summary = "Returnează toate produsele")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getAllProducts() {
        return "Toate produsele";
    }


    @GetMapping("/id/{id}")
    @Operation(summary = "Returnează produsul cu id-ul specificat")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductById() {
        return "Produsul cu id-ul specificat";
    }

    @GetMapping("/sku/{sku}")
    @Operation(summary = "Returnează produsul cu sku-ul specificat")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductBySKU() {
        return "Produsul cu sku-ul specificat";
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Returnează produsele din categoria specificată")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByCategory() {
        return "Produsele din categoria specificată";
    }

    @GetMapping("/price/between/{min}/{max}")
    @Operation(summary = "Returnează produsele cu prețul între min și max")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByPriceBetween() {
        return "Produsele cu prețul între min și max";
    }


    @GetMapping("/price/lessThan/{max}")
    @Operation(summary = "Returnează produsele cu prețul mai mic decât max")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByPriceLessThan() {
        return "Produsele cu prețul mai mic decât max";
    }


    @GetMapping("/price/greaterThan/{min}")
    @Operation(summary = "Returnează produsele cu prețul mai mare decât min")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByPriceGreaterThan() {
        return "Produsele cu prețul mai mare decât min";
    }

    @GetMapping("/price/lessThan/{max}/category/{category}")
    @Operation(summary = "Returnează produsele cu prețul mai mic decât max și din categoria specificată")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByPriceLessThanAndCategory() {
        return "Produsele cu prețul mai mic decât max și din categoria specificată";
    }

    @GetMapping("/price/greaterThan/{min}/category/{category}")
    @Operation(summary = "Returnează produsele cu prețul mai mare decât min și din categoria specificată")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String getProductsByPriceGreaterThanAndCategory() {
        return "Produsele cu prețul mai mare decât min și din categoria specificată";
    }

    @GetMapping("/price/between/{min}/{max}/category/{category}")
    @Operation(summary = "Returnează produsele cu prețul între min și max și din categoria specificată")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String getProductsByPriceBetweenAndCategory() {
        return "Produsele cu prețul între min și max și din categoria specificată";
    }



    @PostMapping("/add")
    @Operation(summary = "Adaugă un produs nou")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "text/plain"))

    public String addProduct() {
        return "Adaugă un produs nou";
    }

    @PostMapping("/update/{sku}")
    @Operation(summary = "Actualizează un produs existent")
    @ApiResponse(responseCode = "202", description = "Accepted", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))
    public String updateProduct() {
        return "Actualizează un produs existent";
    }


    @PostMapping("/delete/{sku}")
    @Operation(summary = "Șterge un produs existent")
    @ApiResponse(responseCode = "200", description = "Succes", content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "text/plain"))

    public String deleteProduct() {
        return "Șterge un produs existent";
    }


}