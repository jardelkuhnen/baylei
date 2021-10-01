package br.com.baylei.config;

import br.com.baylei.adapter.ClientServiceAdapter;
import br.com.baylei.adapter.ProductServiceAdapter;
import br.com.baylei.adapter.SellerServiceAdapter;
import br.com.baylei.api.ClientService;
import br.com.baylei.api.ProductService;
import br.com.baylei.api.SellerService;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.ports.ProductPersistencePort;
import br.com.baylei.ports.SellerPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServicesConfig {

    @Bean
    public ClientService getClientService(ClientPersistencePort clientPersistencePort) {
        return new ClientServiceAdapter(clientPersistencePort);
    }

    @Bean
    public ProductService getProductService(ProductPersistencePort productPersistencePort) {
        return new ProductServiceAdapter(productPersistencePort);
    }

    @Bean
    public SellerService getSellerService(SellerPersistencePort sellerPersistencePort) {
        return new SellerServiceAdapter(sellerPersistencePort);
    }
}
