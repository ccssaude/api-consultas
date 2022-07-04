package com.api.consultingcontrolhospital.Service;


import com.api.consultingcontrolhospital.Models.PacienteModel;
import com.api.consultingcontrolhospital.Repositories.PacienteRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class PacienteService {

final PacienteRespository pacienteRespository;

public PacienteService (PacienteRespository pacienteRespository){
    this.pacienteRespository = pacienteRespository;
}
@Transactional
    public PacienteModel save(PacienteModel pacienteModel){
       return pacienteRespository.save(pacienteModel);
}
public Page<PacienteModel> findAll(Pageable pageable){
    return pacienteRespository.findAll(pageable);
}

}
