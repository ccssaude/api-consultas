package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Dtos.PacienteDto;
import com.api.consultingcontrolhospital.Models.PacienteModel;
import com.api.consultingcontrolhospital.Service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge =3600)
@RequestMapping("/referencia/ccu-tracker/paciente")

public class PacienteController {
final PacienteService pacienteService;
public PacienteController(PacienteService pacienteService){
    this.pacienteService = pacienteService;
}
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid PacienteDto pacienteDto){
        var consultaModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, consultaModel);
        pacienteModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteModel));
    }
}
