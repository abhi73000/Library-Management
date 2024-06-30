package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.service.DataInitializationService;

@SpringBootApplication
public class LibraryManagementSystem2Application implements CommandLineRunner {

	 @Autowired
	    private DataInitializationService dataInitializationService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystem2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataInitializationService.initializeData();
		
	}

}
