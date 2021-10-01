package br.com.baylei.config;

import br.com.baylei.adapter.ClientServiceAdapter;
import br.com.baylei.adapter.SellerServiceAdapter;
import br.com.baylei.api.ClientService;
import br.com.baylei.api.SellerService;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.ports.SellerPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ClientService getClientService(ClientPersistencePort clientPersistencePort) {
        return new ClientServiceAdapter(clientPersistencePort);
    }

    @Bean
    public SellerService getSellerService(SellerPersistencePort sellerPersistencePort) {
        return new SellerServiceAdapter(sellerPersistencePort);
    }

}
