package com.demo.demoHub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;

import com.demo.demoHub.crypto.entity.Web3jEther;

@Configuration
@ComponentScan(basePackages = "com.demo.demoHub.*")
public class AppConfig {

	@Bean 
	public Web3jEther getWeb3j() {
		Web3jEther web3j = new Web3jEther();
		return web3j;
	}
}
