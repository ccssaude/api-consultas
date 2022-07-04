package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Dtos.PacienteDto;
import com.api.consultingcontrolhospital.Models.PacienteModel;
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
import java.util.UUID;

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
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        pacienteModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteModel));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteModel>> getAllPaciente(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteModelOptional.get());
    }

}
