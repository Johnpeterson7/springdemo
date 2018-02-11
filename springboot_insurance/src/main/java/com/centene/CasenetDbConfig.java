package com.centene;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "casenetEntityManagerFactory",
    transactionManagerRef = "casenetTransactionManager", basePackages = {"com.centene.casenet.repo"})
public class CasenetDbConfig {

  @Bean(name = "casenetDataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "casenetEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean casenetEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("casenetDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.centene.casenet.domain").persistenceUnit("casenet")
        .build();
  }

  @Bean(name = "casenetTransactionManager")
  public PlatformTransactionManager casenetTransactionManager(
      @Qualifier("casenetEntityManagerFactory") EntityManagerFactory casenetEntityManagerFactory) {
    return new JpaTransactionManager(casenetEntityManagerFactory);
  }

}
