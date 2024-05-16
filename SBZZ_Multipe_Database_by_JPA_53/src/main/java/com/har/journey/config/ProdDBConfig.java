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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//#01. H2 DB


@EnableTransactionManagement
@EnableJpaRepositories( 
		            entityManagerFactoryRef = "prodEntityManagerFactory",
		            transactionManagerRef = "prodTransactionManager",
		            basePackages = "com.har.journey.prod.repo"
		)
@Configuration
public class ProdDBConfig {

	// #01 . Datasource
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "db1.datasource")
	public DataSource prodDs() {
		return DataSourceBuilder.create().build();
	}

	//#02 .EntityManagerFactory
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean prodEntityManagerFactory(EntityManagerFactoryBuilder emf) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return emf.dataSource(prodDs())
				.packages("com.har.journey.prod.model")
				.properties(properties)
				.build();
	}
	
	//#03. TransactionManager
	@Primary
	@Bean
	public PlatformTransactionManager prodTransactionManager(@Qualifier("prodEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	

}
