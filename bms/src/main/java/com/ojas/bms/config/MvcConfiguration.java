package com.ojas.bms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.ojas.bms")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired

	private Environment env;

	@Bean

	public ViewResolver getViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");

		resolver.setSuffix(".jsp");

		return resolver;

	}

	@Override

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

	@Bean

	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));

		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));

		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));

		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));

		return dataSource;

	}

	@Bean

	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(getDataSource());

		sessionFactory.setPackagesToScan(new String[] { "com.ojas._03SpringMVCLoginApplication.model"

		});

		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;

	}

	private Properties hibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));

		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));

		return properties;

	}

	@Bean

	public HibernateTemplate hibernateTemplate() {

		return new HibernateTemplate(sessionFactory().getObject());

	}

	@Bean

	public HibernateTransactionManager hiber() {

		return new HibernateTransactionManager(sessionFactory().getObject());

	}

}
