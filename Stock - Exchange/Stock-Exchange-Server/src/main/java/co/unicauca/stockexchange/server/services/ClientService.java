package co.unicauca.stockexchange.server.services;

import co.unicauca.stockexchange.server.acces.IClientRepository;
import co.unicauca.stockexchange.server.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private IClientRepository repositoryClient;

    public synchronized Client findClient(String idClient) {
        return repositoryClient.findClient(idClient);
    }

    public synchronized List<Client> getClients() {
        return repositoryClient.getClients();
    }

}
