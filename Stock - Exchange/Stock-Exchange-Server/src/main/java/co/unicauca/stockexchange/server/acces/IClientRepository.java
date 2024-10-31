package co.unicauca.stockexchange.server.acces;

import co.unicauca.stockexchange.server.domain.Action;
import co.unicauca.stockexchange.server.domain.Client;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository {

    /**
     * Busca un cliente por su ID.
     *
     * @param idClient ID del cliente a buscar.
     * @return Cliente correspondiente al ID proporcionado, o null si no se
     * encuentra.
     */
    public Client findClient(String idClient);

    /**
     * Obtiene la lista de todos los clientes en el repositorio.
     *
     * @return Lista de todos los clientes almacenados en el repositorio.
     */
    public List<Client> getClients();

    /**
     * Obtiene la lista de acciones asociadas a un cliente.
     *
     * @param myClient Cliente del cual se desean obtener las acciones.
     * @return Lista de acciones asociadas al cliente especificado.
     */
    public List<Action> getActions(Client myClient);

    /**
     * Busca una acción asociada a un cliente por los IDs del cliente y la
     * acción.
     *
     * @param myClient Cliente.
     * @param idAction ID de la acción a buscar.
     * @return Acción correspondiente a los IDs proporcionados, o null si no se
     * encuentra.
     */
    public Action findAction(Client myClient, String idAction);

    /**
     * Agrega una nueva acción asociada a un cliente con umbrales especificados.
     *
     * @param myClient Cliente al cual se agregará la acción.
     * @param myAction Acción a agregar.
     * @return Mensaje de confirmación.
     */
    public String addAction(Client myClient, Action myAction);

    /**
     * Actualiza los umbrales de una acción asociada a un cliente.
     *
     * @param myClient Cliente al cual pertenece la acción.
     * @param myAction Acción a actualizar.
     * @param lowerThreshold Nuevo umbral inferior.
     * @param upperThreshold Nuevo umbral superior.
     * @return Mensaje de confirmación.
     */
    public String updateThresholds(Client myClient, Action myAction, double lowerThreshold, double upperThreshold);

    /**
     * Elimina una acción asociada a un cliente.
     *
     * @param myClient Cliente al cual pertenece la acción.
     * @param myAction Acción a eliminar.
     * @return Mensaje de confirmación.
     */
    public String deleteAction(Client myClient, Action myAction);

}
