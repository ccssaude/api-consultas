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
import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day==4){
            var pacienteModel = new PacienteModel();
            BeanUtils.copyProperties(pacienteDto, pacienteModel);
            pacienteModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("GMT+2")));
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteModel));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("As marcações apenas podem ser alocadas para segundas e sextas");
        }
    }

    @GetMapping
    public ResponseEntity<Page<PacienteModel>> getAllPaciente(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        return pacienteModelOptional.<ResponseEntity<Object>>map(pacienteModel -> ResponseEntity.status(HttpStatus.OK).body(pacienteModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado !"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePaciente(@PathVariable(value = "id") UUID id, @RequestBody @Valid PacienteDto pacienteDto){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        pacienteModel.setId(pacienteModelOptional.get().getId());
        pacienteModel.setRegistrationDate(pacienteModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(pacienteModel));
    }

}
