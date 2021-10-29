package br.com.baylei.config;

import br.com.baylei.adapter.*;
import br.com.baylei.api.*;
import br.com.baylei.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationServicesConfig {

    @Primary
    @Bean(name = "client-service-mongo")
    public ClientService getClientServiceMongo(ClientPersistencePort clientPersistencePort) {
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

    @Bean
    public OrderSaleService getOrderSaleService(OrderSalePersistencePort orderSalePersistencePort,
                                                SellerPersistencePort sellerPersistencePort,
                                                ClientPersistencePort clientPersistencePort,
                                                ProductPersistencePort productPersistencePort) {
        return new OrderSaleServiceAdapter(orderSalePersistencePort,
                sellerPersistencePort,
                clientPersistencePort,
                productPersistencePort);
    }

    @Bean
    public PlanService getPlanService(PlanPersistencePort planPersistencePort,
                                      ProductPersistencePort productPersistencePort,
                                      ClientPersistencePort clientPersistencePort) {
        return new PlanServiceAdapter(planPersistencePort, productPersistencePort, clientPersistencePort);
    }

//    @Bean(name = "client-service-h2")
//    public ClientService getClientServiceH2(@Qualifier("client-persistence-h2") ClientPersistencePort clientPersistencePortH2) {
//        return new ClientServiceAdapter(clientPersistencePortH2);
//    }

}
