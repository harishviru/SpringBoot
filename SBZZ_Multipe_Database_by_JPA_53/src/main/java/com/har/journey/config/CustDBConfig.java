package com.har.journey.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(
		                   entityManagerFactoryRef = "custEntityManagerFactory",
		                   transactionManagerRef = "custTransactionManager",
		                   basePackages  = "com.har.journey.cust.repo"
		)
@Configuration
public class CustDBConfig {

	
	//#01. Datasource
	@ConfigurationProperties(prefix = "db2.datasource")
	@Bean
	public DataSource custDs() {
		return DataSourceBuilder.create().build();
	}
	
	//#02. EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean custEntityManagerFactory(EntityManagerFactoryBuilder emfb) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(custDs())
				   .packages("com.har.journey.cust.model")
				   .properties(properties)
				   .build();
	}
	
	//#03. TransactionManager
	@Bean
	public PlatformTransactionManager custTransactionManager(@Qualifier("custEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}
