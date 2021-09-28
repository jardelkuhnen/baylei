package br.com.baylei.config;

import br.com.baylei.adapter.ClientServiceAdapter;
import br.com.baylei.api.ClientService;
import br.com.baylei.ports.ClientPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ClientService getClientService(ClientPersistencePort clientPersistencePort) {
        return new ClientServiceAdapter(clientPersistencePort);
    }

}
