package com.api.consultingcontrolhospital.Controllers;


import com.api.consultingcontrolhospital.Dtos.ConsultaDto;
import com.api.consultingcontrolhospital.Models.ConsultaModel;
import com.api.consultingcontrolhospital.Service.ConsultaService;
import com.api.consultingcontrolhospital.Service.VagaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/referencia/ccu-tracker/consulta")

public class ConsultaController {
    final ConsultaService consultaService;
     public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ConsultaDto consultaDto){
//        if(consultaService.existsById(consultaDto.getId())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Esta consulta ja foi alocada a outra paciente !");
//        }
        //will come date and vacancy quantity validation
        var consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaDto, consultaModel);
        consultaModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consultaModel));
    }

}

