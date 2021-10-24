package br.com.baylei.h2.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(
//        entityManagerFactoryRef = "h2EntityManagerFactory",
//        transactionManagerRef = "h2TransactionManager",
        basePackages = {"br.com.baylei.h2"})
public class H2Config {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.h2")
//    public DataSource getDatasource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(final EntityManagerFactoryBuilder factoryBuilder) {
//        return factoryBuilder
//                .dataSource(getDatasource())
//                .packages("br.com.baylei.h2")
//                .persistenceUnit("h2PersistenceUnit")
//                .build();
//    }
//
//    @Bean
//    public JpaTransactionManager h2TransactionManager(@Qualifier("h2EntityManagerFactory") final EntityManagerFactory factory) {
//        return new JpaTransactionManager(factory);
//    }

}
