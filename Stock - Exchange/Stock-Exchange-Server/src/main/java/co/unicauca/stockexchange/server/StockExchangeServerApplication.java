package co.unicauca.stockexchange.server;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExchangeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeServerApplication.class, args);
                //SpringApplication appSpring = new SpringApplication(StockExchangeServerApplication.class);
                //appSpring.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
                //appSpring.run(args);
	}

}
