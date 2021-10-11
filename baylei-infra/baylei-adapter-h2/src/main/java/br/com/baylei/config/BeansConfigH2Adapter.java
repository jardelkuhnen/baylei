package br.com.baylei.config;

import br.com.baylei.adapter.ClientH2JpaAdapter;
import br.com.baylei.repository.ClientRepository;
import br.com.baylei.usecase.ClientPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfigH2Adapter {

    @Bean(name = "client-persistence-h2")
    public ClientPersistencePort getClientPersistencePortH2(ClientRepository clientRepository) {
        return new ClientH2JpaAdapter(clientRepository);
    }

}
