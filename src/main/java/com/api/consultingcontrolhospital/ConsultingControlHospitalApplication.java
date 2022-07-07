package com.api.consultingcontrolhospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@RestController
@EnableScheduling
public class ConsultingControlHospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsultingControlHospitalApplication.class, args);
	}
	@GetMapping("/check-date")
	public String index(){
		Calendar calendar= Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		if (day==5 || day==6){
			return "Consulta alocada com sucesso !";
		}else {
			return "As marcações apenas podem ser alocadas para quita-feira ou sexta-feira";
		}
	}
}
