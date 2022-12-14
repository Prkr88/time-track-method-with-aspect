package com.aspectDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aspectDemo.business.BusinessLogic;

@SpringBootApplication
public class AspectDemoApplication implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final BusinessLogic businessLogic;

	// using spring constructor injection
	public AspectDemoApplication(BusinessLogic businessLogic) {
		this.businessLogic = businessLogic;
	}

	public static void main(String[] args) {
		SpringApplication.run(AspectDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(businessLogic.executeBusinessLogic());
	}
}
