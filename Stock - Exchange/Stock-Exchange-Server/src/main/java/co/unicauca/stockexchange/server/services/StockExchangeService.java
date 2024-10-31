package co.unicauca.stockexchange.server.services;

import co.unicauca.stockexchange.server.acces.IStockExchangeRepository;
import co.unicauca.stockexchange.server.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockExchangeService {

    @Autowired
    private IStockExchangeRepository repositoryStock;

    public StockExchangeService(IStockExchangeRepository repositoryStock) {

        this.repositoryStock = repositoryStock;
    }

    public synchronized List<Action> getActions() {
        return repositoryStock.getActions();
    }

    public synchronized Action findAction(String idAction) {
        return repositoryStock.findAction(idAction);
    }
}
