package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.ConsultaModel;
import com.api.consultingcontrolhospital.Repositories.ConsultaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaService {
    final ConsultaRepository consultaRepository;

    public ConsultaService (ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }
    @Transactional
    public ConsultaModel save (ConsultaModel consultaModel){
        return consultaRepository.save(consultaModel);
    }
    @Transactional
    public Page<ConsultaModel> findAll (Pageable pageable){
        return consultaRepository.findAll(pageable);
    }
    public Optional<ConsultaModel> findById(UUID id){
        return consultaRepository.findById(id);
    }
    @Transactional
    public void delete(ConsultaModel consultaModel){
        consultaRepository.delete(consultaModel);
    }


}
