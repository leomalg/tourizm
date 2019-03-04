package fr.malgrange.tourizm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.malgrange.tourizm.repository.StepRepository;

@SpringBootApplication
public class TourizmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourizmApplication.class, args);
	}

}
