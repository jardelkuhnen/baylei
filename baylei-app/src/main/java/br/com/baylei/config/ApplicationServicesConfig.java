package br.com.baylei.config;

import br.com.baylei.adapter.*;
import br.com.baylei.api.*;
import br.com.baylei.ports.*;
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
}
