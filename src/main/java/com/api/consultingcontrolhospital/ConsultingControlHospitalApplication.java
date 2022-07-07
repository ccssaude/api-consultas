package com.api.consultingcontrolhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;

@SpringBootApplication
@RestController
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
			return"As marcações apenas podem ser alocadas para quita-feira ou sexta-feira";
		}
	}
}
