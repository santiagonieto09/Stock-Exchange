package co.unicauca.stockexchange.server.services;

import co.unicauca.stockexchange.server.acces.IClientRepository;
import co.unicauca.stockexchange.server.acces.IStockExchangeRepository;
import co.unicauca.stockexchange.server.domain.Action;
import co.unicauca.stockexchange.server.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private IClientRepository repositoryClient;
    @Autowired
    private IStockExchangeRepository repositoryStock;

    public synchronized List<Action> getActions(String idClient) {
        Client myClient = repositoryClient.findClient(idClient);
        if (myClient == null) {
            return null;
        }
        return repositoryClient.getActions(myClient);
    }

    public synchronized Action findAction(String idClient, String idAction) {
        Client myClient = repositoryClient.findClient(idClient);
        if (myClient == null) {
            return null;
        }
        return repositoryClient.findAction(myClient, idAction);
    }

    public synchronized String addAction(String idClient, String idAction, double lowerThreshold, double upperThreshold) {
        Action foundAction = repositoryStock.findAction(idAction);
        Client myClient = repositoryClient.findClient(idClient);
        if (myClient == null) {
            return "El cliente con id " + idClient + " no existe.";
        }
        if (foundAction == null) {
            return "Accion con Id" + idAction + "no existe.";
        }
        Action myAction = new Action(foundAction);
        if (!validateThresholds(myAction, lowerThreshold, upperThreshold)) {
            return "Los umbrales están mal definidos";
        }
        myAction.setLowerThreshold(lowerThreshold);
        myAction.setUpperThreshold(upperThreshold);
        return repositoryClient.addAction(myClient, myAction);
    }

    public synchronized String updateThresholds(String idClient, String idAction, double lowerThreshold, double upperThreshold) {
        Client myClient = repositoryClient.findClient(idClient);
        if (myClient == null) {
            return "El cliente con id " + idClient + " no existe.";
        }
        Action myAction = repositoryClient.findAction(myClient, idAction);
        if (!validateThresholds(myAction, lowerThreshold, upperThreshold)) {
            return "Los umbrales están mal definidos";
        }
        return repositoryClient.updateThresholds(myClient, myAction, lowerThreshold, upperThreshold);
    }

    public synchronized String deleteAction(String idClient, String idAction) {
        Client myClient = repositoryClient.findClient(idClient);
        if (myClient == null) {
            return "El cliente con id " + idClient + " no existe.";
        }
        Action myAction = repositoryClient.findAction(myClient, idAction);
        if (myAction == null) {
            return "Accion con Id" + idAction + "no existe.";
        }
        return repositoryClient.deleteAction(myClient, myAction);
    }

    private boolean validateThresholds(Action myAction, double lowerThreshold, double upperThreshold) {
        return lowerThreshold <= myAction.getCurrentPrice() && upperThreshold >= myAction.getCurrentPrice();
    }
}
