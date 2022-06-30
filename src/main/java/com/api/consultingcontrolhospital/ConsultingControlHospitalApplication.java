package com.api.consultingcontrolhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsultingControlHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultingControlHospitalApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Welcome to consulting-Control RestFull API";
	}

}
