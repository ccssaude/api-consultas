package com.api.consultingcontrolhospital.Service;


import com.api.consultingcontrolhospital.Models.VagaModel;
import com.api.consultingcontrolhospital.Repositories.VagaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VagaService {
    final VagaRepository vagaRepository;
    public VagaService (VagaRepository vagaRepository){
        this.vagaRepository = vagaRepository;
    }
    @Transactional
    public VagaModel save(VagaModel vagaModel){
        return vagaRepository.save(vagaModel);
    }

}
