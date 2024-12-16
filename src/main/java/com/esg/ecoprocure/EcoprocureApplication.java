package com.esg.ecoprocure;

import com.esg.ecoprocure.repository.SupplierRepository;
import com.esg.ecoprocure.service.SupplierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;


@SpringBootApplication
public class EcoprocureApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoprocureApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		return sessionFactory;
//	}


//	@Configuration
//	public class DataSourceConfig {
//		@Bean
//		public DataSource getDataSource() {
//			return DataSourceBuilder.create()
//					.driverClassName("com.mysql.jdbc.Driver")
//					.url("jdbc:mysql://localhost/ecoprocure")
//					.username("root")
//					.password("sudhanshu")
//					.build();
//		}
//	}
}
