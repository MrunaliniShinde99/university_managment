package com.cg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class UniversityCourseAppApplication {
	
	  private final static Logger logger =LogManager.getLogger(UniversityCourseAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UniversityCourseAppApplication.class, args);
		logger.info("test logger");
	}
}
