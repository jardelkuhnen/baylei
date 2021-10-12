package br.com.baylei.config;

import br.com.baylei.adapter.*;
import br.com.baylei.usecase.*;
import br.com.baylei.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansConfig {

    @Primary
    @Bean(name = "client-persistence-mongo")
    public ClientPersistencePort getClientPersistencPort(@Qualifier("client-repository-mongo") ClientRepository clientRepository) {
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

    @Bean
    public PlanPersistencePort getPlanPersistencePort(PlanRepository planRepository) {
        return new PlanSpringJpaAdapter(planRepository);
    }

    @Bean
    public OrderSalePersistencePort getOrderSalePersistencePort(OrderSaleRepository orderSaleRepository) {
        return new OrderSaleSpringJpaAdapter(orderSaleRepository);
    }




}
