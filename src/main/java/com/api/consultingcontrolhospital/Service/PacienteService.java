package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.Paciente;
import com.api.consultingcontrolhospital.Repositories.PacienteRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
public class PacienteService {

final PacienteRespository pacienteRespository;

public PacienteService (PacienteRespository pacienteRespository){
    this.pacienteRespository = pacienteRespository;
}
@Transactional
    public Paciente save(Paciente paciente){
       return pacienteRespository.save(paciente);
}
    @Transactional
    public Page<Paciente> findAll(Pageable pageable){
        return pacienteRespository.findAll(pageable);
}
    public Optional<Paciente> findById(UUID id){
        return pacienteRespository.findById(id);
    }


}
