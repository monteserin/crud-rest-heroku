package com.pablomonteserin.prueba.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.pablomonteserin.prueba.persistence.repository")
@EnableTransactionManagement
public class PruebaConfiguration {
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	 
	    return transactionManager;
	}
	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan("com.pablomonteserin.prueba.persistence.model");
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    
	    dataSource.setUrl("jdbc:mysql://localhost:3306/invitado?serverTimezone=UTC");
	    dataSource.setUsername( "root" );
	    dataSource.setPassword( "" );
	    
	    dataSource.setUrl("jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306/heroku_a674b4cf275a6fa?serverTimezone=UTC");
	    dataSource.setUsername( "bc969c062c9d81" );
	    dataSource.setPassword( "424a2969" );
	    return dataSource;
	}
	private Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.hbm2ddl.auto", "create");
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        
	    return properties;
	}
}