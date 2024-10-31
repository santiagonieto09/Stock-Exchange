package co.unicauca.stockexchange.server.acces;

import co.unicauca.stockexchange.server.domain.Action;
import co.unicauca.stockexchange.server.domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository implements IClientRepository {

    /**
     * Lista que almacena objetos Client representando a los clientes en el
     * repositorio.
     */
    private List<Client> clients;

    /**
     * Repositorio de clientes que gestiona la información de los clientes y sus
     * acciones en la bolsa de valores. Se inicializa con un conjunto
     * predefinido de clientes al crear una nueva instancia.
     *
     */
    public ClientRepository() {

        clients = new ArrayList<>();
        initialize();
    }

    /**
     * Inicializa el repositorio de clientes con un conjunto predefinido de
     * clientes. Cada cliente creado durante la inicialización también puede
     * tener acciones asociadas.
     */
    public void initialize() {
        clients.add(new Client("C01", "Daniel", "+57 3215896587"));
        clients.add(new Client("C02", "Camila", "+57 3219874585"));
        clients.add(new Client("C03", "Santiago", "+57 3122478963"));
    }

    @Override
    public Client findClient(String idClient) {
        for (Client client : clients) {
            if (client.getClientId().equals(idClient.toUpperCase())) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Action> getActions(Client myClient) {
        return myClient.getActions();
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public Action findAction(Client myClient , String idAction) {
        List<Action> myActions = myClient.getActions();
        for (Action action : myActions) {
            if (action.getActionId().equals(idAction.toUpperCase())) {
                return action;
            }
        }
        return null;
    }

    @Override
    public String addAction(Client myClient, Action myAction) {
        myClient.addAction(myAction);
        return "Action added successfully";
    }

    @Override
    public String updateThresholds(Client myClient, Action myAction, double lowerThreshold, double upperThreshold) {
        myAction.setLowerThreshold(lowerThreshold);
        myAction.setUpperThreshold(upperThreshold);
        return "Action thresholds updated successfully";
    }

    @Override
    public String deleteAction(Client myClient, Action myAction) {
        myClient.deleteAction(myAction);
        return "Action deleted successfully";

    }

}
