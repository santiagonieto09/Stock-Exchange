package co.unicauca.stockexchange.server.controller;

import co.unicauca.stockexchange.server.domain.Action;
import co.unicauca.stockexchange.server.services.StockExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    //USO: http://localhost:8080/stockExchange
    @Operation(description = "Obtiene la lista completa de acciones en el repositorio de la bolsa de valores.")
    @ApiResponse(responseCode = "200", description = "Lista de todas las acciones almacenadas en el repositorio.")
    @GetMapping
    public List<Action> getActions() {

        return stockExchangeService.getActions();
    }
    @Operation(description = "Busca una acción por su ID.")
    @ApiResponse(responseCode = "200", description = "La acción correspondiente al ID proporcionado")
    //USO: http://localhost:8080/stockExchange/A01
    @GetMapping("/{id}")
    public Action findAction(@Parameter(description = "ID de la acción.")@PathVariable String id) {
        return stockExchangeService.findAction(id);
    }
}
