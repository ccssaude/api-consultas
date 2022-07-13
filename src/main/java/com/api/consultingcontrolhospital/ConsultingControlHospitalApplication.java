package com.api.consultingcontrolhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		c.add(Calendar.DATE,7);
		System.out.println(df.format(c.getTime()));
		// Get Next fRIDAY
//		return  Calendar.getInstance().getTime();
		return "AS datas : " +  Calendar.getInstance().getTime();
	}
}
