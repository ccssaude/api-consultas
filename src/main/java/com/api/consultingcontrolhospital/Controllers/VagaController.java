package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Models.Consulta;
import com.api.consultingcontrolhospital.Service.StockVagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ccu-tracker/")

public class VagaController {
    final StockVagaService stockVagaService;
    public VagaController(StockVagaService stockVagaService) {
        this.stockVagaService = stockVagaService;
    }
    @GetMapping("/Mavalane")
    public ResponseEntity<Consulta>getHospitalGeralMavalane() throws ParseException {
    return ResponseEntity.status(HttpStatus.OK).body(stockVagaService.CheckMavalane());
    }
    @GetMapping("/Central")
    public ResponseEntity<Consulta>getHospitalCentral() throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(stockVagaService.CheckHospitalCentral());
    }
    @GetMapping("/Macamo")
    public ResponseEntity<Consulta>getHospitalJoseMacamo() throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(stockVagaService.CheckJoseMacamo());
    }

}