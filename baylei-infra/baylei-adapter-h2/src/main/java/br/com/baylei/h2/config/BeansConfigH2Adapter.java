package br.com.baylei.h2.config;

import br.com.baylei.h2.adapter.ClientH2JpaAdapter;
import br.com.baylei.h2.repository.ClientRepository;
import br.com.baylei.usecase.ClientPersistencePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfigH2Adapter {

    @Bean(name = "client-persistence-h2")
    public ClientPersistencePort getClientPersistencePortH2(@Qualifier("client-repository-h2") ClientRepository clientRepository) {
        return new ClientH2JpaAdapter(clientRepository);
    }

}
