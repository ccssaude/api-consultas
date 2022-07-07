package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.Hospital;
import com.api.consultingcontrolhospital.Repositories.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

}
