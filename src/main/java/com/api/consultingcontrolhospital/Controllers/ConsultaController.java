package com.api.consultingcontrolhospital.Controllers;


import com.api.consultingcontrolhospital.Dtos.ConsultaDto;
import com.api.consultingcontrolhospital.Models.ConsultaModel;
import com.api.consultingcontrolhospital.Service.ConsultaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/referencia/ccu-tracker/consulta")

public class ConsultaController {
    final ConsultaService consultaService;
     public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }
    @PostMapping
    public ResponseEntity<Object> saveConsulta(@RequestBody @Valid ConsultaDto consultaDto){
//        if(consultaService.existsById(consultaDto.getVagas_dispo())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: O número de consultas por dia esgotou !");
//        }
        //will come date and vacancy quantity validation
        var consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaDto, consultaModel);
        consultaModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consultaModel));
    }
    @GetMapping
    public ResponseEntity<Page<ConsultaModel>> getAllConsulta(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
         return ResponseEntity.status(HttpStatus.OK).body(consultaService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneConsulta(@PathVariable(value = "id") UUID id){
        Optional<ConsultaModel> consultaModelOptional = consultaService.findById(id);
        if (!consultaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Desculpa, a consulta que procura não existe!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaModelOptional.get());
    }


}

