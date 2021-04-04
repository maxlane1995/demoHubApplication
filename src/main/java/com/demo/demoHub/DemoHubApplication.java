package com.demo.demoHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
//@ComponentScan(basePackages = "com.demo.demoHub.model.*")
//@EnableJpaRepositories("com.demo.demoHub.dao")
//@EntityScan("com.demo.demoHub.model")
public class DemoHubApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoHubApplication.class, args);

	}
	

	

}     
