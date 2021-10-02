package br.com.baylei.config;

import br.com.baylei.adapter.*;
import br.com.baylei.ports.*;
import br.com.baylei.repository.*;
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

    @Bean
    public OrderSalePersistencePort getOrderSalePersistencePort(OrderSaleRepository orderSaleRepository) {
        return new OrderSaleSpringJpaAdapter(orderSaleRepository);
    }

    @Bean
    public PlanPersistencePort getPlanPersistencePort(PlanRepository planRepository) {
        return new PlanSpringJpaAdapter(planRepository);
    }


}
