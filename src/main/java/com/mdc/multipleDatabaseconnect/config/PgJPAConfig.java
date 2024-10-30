package com.mdc.multipleDatabaseconnect.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(transactionManagerRef = "pgPlatformTransactionManager",
        basePackages = "com.mdc.multipleDatabaseconnect.productRepo",
        entityManagerFactoryRef = "pgEntityManager"
)
public class PgJPAConfig {


    @Bean
    LocalContainerEntityManagerFactoryBean pgEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("pgDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder.dataSource(dataSource)
                .packages("com.mdc.multipleDatabaseconnect.product")
                .build();
    }

    @Bean
    PlatformTransactionManager pgPlatformTransactionManager(@Qualifier("pgEntityManager") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
