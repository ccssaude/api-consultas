package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.PacienteModel;
import com.api.consultingcontrolhospital.Repositories.PacienteRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;


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
    @Transactional
    public Page<PacienteModel> findAll(Pageable pageable){
        return pacienteRespository.findAll(pageable);
}
    public Optional<PacienteModel> findById(UUID id){
        return pacienteRespository.findById(id);
    }


}
