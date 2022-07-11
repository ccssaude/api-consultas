package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Dtos.HospitalDto;
import com.api.consultingcontrolhospital.Dtos.PacienteDto;
import com.api.consultingcontrolhospital.Models.Consulta;
import com.api.consultingcontrolhospital.Models.Hospital;
import com.api.consultingcontrolhospital.Models.Paciente;
import com.api.consultingcontrolhospital.Models.StockVaga;
import com.api.consultingcontrolhospital.Service.StockVagaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ccu-tracker/vaga")

public class StockVagaController {
    final StockVagaService stockVagaService;

    public StockVagaController(StockVagaService stockVagaService) {
        this.stockVagaService = stockVagaService;
    }
    @GetMapping
    public ResponseEntity<Consulta>getConsultaDisponivel() throws ParseException {
    return ResponseEntity.status(HttpStatus.OK).body(stockVagaService.VerificarDisponibilidadeConsulta());
     }
//    @PostMapping
//    public ResponseEntity<Object> saveVaga() {
//        var consulta = new Consulta();
//        return ResponseEntity.status(HttpStatus.CREATED).body(stockVagaService.save(consulta));
//    }

}
