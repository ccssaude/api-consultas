package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Dtos.PacienteDto;

import com.api.consultingcontrolhospital.Models.Paciente;
import com.api.consultingcontrolhospital.Service.PacienteService;
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

@RestController
@CrossOrigin(origins = "*", maxAge =3600)
@RequestMapping("/ccu-tracker/")

public class PacienteController {
    final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService){
    this.pacienteService = pacienteService;
}
    @PostMapping("/add-pacient")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid PacienteDto pacienteDto){
            var paciente = new Paciente();
            BeanUtils.copyProperties(pacienteDto, paciente);
            paciente.setRegistrationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
    }
    @GetMapping("/get-pacients")
    public ResponseEntity<Page<Paciente>> getAllPaciente(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll(pageable));
    }
    @GetMapping("/pacient{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") Integer id){
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        return pacienteOptional.<ResponseEntity<Object>>map(paciente -> ResponseEntity.status(HttpStatus.OK).body(paciente)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado !"));
    }
}
