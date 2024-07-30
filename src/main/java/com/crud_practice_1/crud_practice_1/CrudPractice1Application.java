package com.crud_practice_1.crud_practice_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.crud_practice_1.crud_practice_1.DAO.StudentDAO;

@SpringBootApplication
public class CrudPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudPractice1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) { // Parameters will hold all the autowired components
																	// for future use
		return runner -> {
			System.out.println("THIS LINE WILL EXECUTE INITIALLY AFTER THE APP HAS BEEN STARTED!");
			// studentDAO.printAll();
		};
	}

	

}
