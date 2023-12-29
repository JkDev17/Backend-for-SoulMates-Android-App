package com.jk.soulmatesbackendandroidapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SoulmatesBackendAndroidAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(SoulmatesBackendAndroidAppApplication.class, args);
	}

}
