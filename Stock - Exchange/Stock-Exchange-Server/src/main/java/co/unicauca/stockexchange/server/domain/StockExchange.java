package co.unicauca.stockexchange.server.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StockExchange {

    private String stockExchangeId;
    private String stockExchangeName;
    private List<Action> actions = new ArrayList<>();

}
