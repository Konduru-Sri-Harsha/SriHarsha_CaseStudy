package org.hcl.configuration;

import java.util.Properties;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class ApplicationContext {
	
	@Autowired
	Environment environment;
	
    @Bean
	public DataSource getDatasource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getProperty("jdbc.driver"));
		datasource.setUrl(environment.getProperty("jdbc.url"));
		datasource.setUsername(environment.getProperty("jdbc.username"));
		datasource.setPassword(environment.getProperty("jdbc.password"));
		return datasource;
	}
	
	public Properties getproperty() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean getFactoryBean() {
		LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
		factorybean.setDataSource(getDatasource());
		factorybean.setHibernateProperties(getproperty());
        factorybean.setPackagesToScan("org.hcl.entities");
		return factorybean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(getFactoryBean().getObject());
		return transactionManager;
	}	
}
