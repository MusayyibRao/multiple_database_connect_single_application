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
@EnableJpaRepositories(transactionManagerRef = "mysqlPlatformTransactionManager",
        basePackages = "com.mdc.multipleDatabaseconnect.orderRepo",
        entityManagerFactoryRef = "mySqlEntityManager"
)
public class MysqlJPAConfig {

    @Bean
   LocalContainerEntityManagerFactoryBean mySqlEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("mysqlDataSource") DataSource dataSource){
       return entityManagerFactoryBuilder.dataSource(dataSource)
               .packages("com.mdc.multipleDatabaseconnect.order")
               .build();
   }

   @Bean
   PlatformTransactionManager mysqlPlatformTransactionManager(@Qualifier("mySqlEntityManager") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
   }

}
