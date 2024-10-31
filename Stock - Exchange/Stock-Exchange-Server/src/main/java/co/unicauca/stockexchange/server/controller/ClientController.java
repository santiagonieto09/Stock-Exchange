package co.unicauca.stockexchange.server.controller;

import co.unicauca.stockexchange.server.services.ClientService;
import co.unicauca.stockexchange.server.domain.Client;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //USO: http://localhost:8080/client
    @Operation(description = "Obtiene la lista de todos los clientes en el repositorio.")
    @ApiResponse(responseCode = "200", description = "Lista de todos los clientes almacenados en el repositorio.")
    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    //USO:http://localhost:8080/client/C01
    @Operation(description = "Busca un cliente por su ID.")
    @ApiResponse(responseCode = "200", description = "Cliente correspondiente al ID proporcionado.")
    @GetMapping("/{id}")
    public Client findClient(@Parameter(description = "ID del cliente a buscar.") @PathVariable String id) {
        return clientService.findClient(id);
    }
}
