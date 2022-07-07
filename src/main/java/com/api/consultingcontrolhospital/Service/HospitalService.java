package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.ConsultingControlHospitalApplication;
import com.api.consultingcontrolhospital.Models.Hospital;
import com.api.consultingcontrolhospital.Repositories.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService {
    final HospitalRepository hospitalRepository;

    public HospitalService (HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }
    @Transactional
    public Hospital save(Hospital hospitalModel){
        return hospitalRepository.save(hospitalModel);
    }
    @Transactional
    public Page<Hospital> findAll(Pageable pageable){
        return hospitalRepository.findAll(pageable);
    }
    public Optional<Hospital> findById(UUID id){
        return hospitalRepository.findById(id);
    }

 //   Logger logger = LoggerFactory.getLogger(ConsultingControlHospitalApplication.class);
//    @Scheduled(fixedRate = 2000L)
//    public void job(){
//        Calendar calendar= Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        var hospital = new Hospital();
//        if (day==5 || day==6){
//            logger.info("Actualizando disponibilidade de vagas no hospital de referencia:  " + new Date());
//        }else{
//            logger.info("Vagas esgotadas !");
//        }
//    }

}
