package com.api.consultingcontrolhospital.Service;
import com.api.consultingcontrolhospital.Models.HospitalModel;
import com.api.consultingcontrolhospital.Models.PacienteModel;
import com.api.consultingcontrolhospital.Repositories.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService {
    final HospitalRepository hospitalRepository;

    public HospitalService (HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }
    @Transactional
    public HospitalModel save(HospitalModel hospitalModel){
        return hospitalRepository.save(hospitalModel);
    }
    @Transactional
    public Page<HospitalModel> findAll(Pageable pageable){
        return hospitalRepository.findAll(pageable);
    }
    public Optional<HospitalModel> findById(UUID id){
        return hospitalRepository.findById(id);
    }


}
