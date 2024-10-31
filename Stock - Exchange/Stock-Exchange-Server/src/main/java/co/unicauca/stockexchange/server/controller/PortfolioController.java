package co.unicauca.stockexchange.server.controller;

import co.unicauca.stockexchange.server.services.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.unicauca.stockexchange.server.domain.Action;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    //USO: http://localhost:8080/portfolio/actions/C01
    @Operation(description = "Obtiene la lista de acciones asociadas a un cliente.")
    @ApiResponse(responseCode = "200", description = "Lista de acciones asociadas al cliente especificado.")
    @GetMapping("/actions/{idClient}")
    public List<Action> getActions(@Parameter(description = "ID del Cliente del cual se desean obtener las acciones.")@PathVariable String idClient) {
        return portfolioService.getActions(idClient);
    }

    //USO: http://localhost:8080/portfolio/action/C01/A01
    @Operation(description = "Busca una acción asociada a un cliente por los IDs del cliente y la accion.")
    @ApiResponse(responseCode = "200", description = "Acción correspondiente a los IDs proporcionados.")
    @GetMapping("/action/{idClient}/{idAction}")
    public Action findAction(@Parameter(description = "ID del cliente.") @PathVariable String idClient, @Parameter(description = "ID de la acción a buscar.")@PathVariable String idAction) {
        return portfolioService.findAction(idClient, idAction);
    }

    //USO: http://localhost:8080/portfolio/addAction/C01/A01/80000/150000
    @Operation(description = "Agrega una nueva acción asociada a un cliente con umbrales especificados.")
    @ApiResponse(responseCode = "200", description = "Mensaje de confirmación.")
    @PostMapping("/addAction/{idClient}/{idAction}/{lowerThreshold}/{upperThreshold}")
    public String addAction(
            @Parameter(description = "ID del cliente.")@PathVariable String idClient,
            @Parameter(description = "ID de la acción a agregar.")@PathVariable String idAction,
            @Parameter(description = "Umbral inferior.") @PathVariable double lowerThreshold,
            @Parameter(description = "Umbral superior.")@PathVariable double upperThreshold) {
        return portfolioService.addAction(idClient, idAction, lowerThreshold, upperThreshold);
    }

    //USO: http://localhost:8080/portfolio/updateAction/C01/A01/85000/155000
    @Operation(description = "Actualiza los umbrales de una acción asociada a un cliente.")
    @ApiResponse(responseCode = "200", description = "Mensaje de confirmación.")
    @PutMapping("/updateAction/{idClient}/{idAction}/{lowerThreshold}/{upperThreshold}")
    public String updateThresholds(
            @Parameter(description = "ID del cliente.")@PathVariable String idClient,
            @Parameter(description = "ID de la acción a agregar.")@PathVariable String idAction,
            @Parameter(description = "Nuevo umbral inferior.")@PathVariable double lowerThreshold,
            @Parameter(description = "Nuevo umbral superior.")@PathVariable double upperThreshold) {
        return portfolioService.updateThresholds(idClient, idAction, lowerThreshold, upperThreshold);
    }

    //USO: http://localhost:8080/portfolio/deleteAction/C01/A01
    @Operation(description = "Elimina una acción asociada a un cliente.")
    @ApiResponse(responseCode = "200", description = "Mensaje de confirmación.")
    @DeleteMapping("/deleteAction/{idClient}/{idAction}")
    public String deleteAction(@Parameter(description = "ID del cliente.")@PathVariable String idClient,
                               @Parameter(description = "ID de la acción a eliminar.")@PathVariable String idAction) {
        return portfolioService.deleteAction(idClient, idAction);
    }
}
