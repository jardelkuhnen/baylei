package br.com.baylei.config;

import br.com.baylei.adapter.ClientSpringJpaAdapter;
import br.com.baylei.adapter.ProductSpringJpaAdapter;
import br.com.baylei.adapter.SellerSpringJpaAdapter;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.ports.ProductPersistencePort;
import br.com.baylei.ports.SellerPersistencePort;
import br.com.baylei.repository.ClientRepository;
import br.com.baylei.repository.ProductRepository;
import br.com.baylei.repository.SellerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ClientPersistencePort getClientPersistencPort(ClientRepository clientRepository) {
        return new ClientSpringJpaAdapter(clientRepository);
    }

    @Bean
    public SellerPersistencePort getSellerPersistencePort(SellerRepository sellerRepository) {
        return new SellerSpringJpaAdapter(sellerRepository);
    }

    @Bean
    public ProductPersistencePort getProductPersistencePort(ProductRepository productRepository) {
        return new ProductSpringJpaAdapter(productRepository);
    }


}
