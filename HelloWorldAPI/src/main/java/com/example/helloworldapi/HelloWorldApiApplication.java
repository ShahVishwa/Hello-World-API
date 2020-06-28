package com.example.helloworldapi;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
//		Properties properties = new Properties();
//		properties.setProperty("spring.main.banner-mode", "off");
//		properties.setProperty("logging.pattern.console", "");
//		application.setDefaultProperties(properties);
//		application.run(args);
	}

}
