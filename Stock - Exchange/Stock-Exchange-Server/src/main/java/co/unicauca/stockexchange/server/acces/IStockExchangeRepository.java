package co.unicauca.stockexchange.server.acces;

import co.unicauca.stockexchange.server.domain.Action;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockExchangeRepository {

    /**
     * Busca una acción por su ID.
     *
     * @param id ID de la acción a buscar.
     * @return La acción correspondiente al ID proporcionado, o null si no se
     * encuentra.
     */
    public Action findAction(String id);

    /**
     * Obtiene la lista completa de acciones en el repositorio.
     *
     * @return Lista de todas las acciones almacenadas en el repositorio.
     */
    public List<Action> getActions();

}
