package com.rec.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


// @EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"com.rec.demo.controller", "com.rec.demo.services", "com.rec.demo.repository"}, exclude = {DataSourceAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource());
    emf.setPackagesToScan("com.rec.demo.entity");
    emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    emf.setJpaProperties(jpaProperties());
    return emf;
}

@Bean
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/rec?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=GMT&characterEncoding=UTF-8");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    return (DataSource) dataSource;
}

@Bean
public Properties jpaProperties() {
    Properties props = new Properties();
    props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    props.put("hibernate.show_sql", true);
    props.put("hibernate.hbm2ddl.auto", "update");
    props.put("security.user.name", "root");
    props.put("security.user.password", "root");
    return props;
}

}
