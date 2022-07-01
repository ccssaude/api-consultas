package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.ConsultaModel;
import com.api.consultingcontrolhospital.Repositories.ConsultaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ConsultaService {
    final ConsultaRepository consultaRepository;

    public ConsultaService (ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

}
