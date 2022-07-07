package com.api.consultingcontrolhospital.Controllers;

import com.api.consultingcontrolhospital.Dtos.HospitalDto;
import com.api.consultingcontrolhospital.Models.HospitalModel;
import com.api.consultingcontrolhospital.Service.HospitalService;
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
@RequestMapping("/referencia/ccu-tracker/hospital")

public class HospitalController {
    final HospitalService hospitalService;
    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }
    @PostMapping
    public ResponseEntity<Object> saveHospital(@RequestBody @Valid HospitalDto hospitalDto){
//        if (vagas_dispo < 10 ){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Vagas esgotadas!");
//        } else {
        var hospitalModel = new HospitalModel();
        BeanUtils.copyProperties(hospitalDto, hospitalModel);
        hospitalModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalService.save(hospitalModel));
//        }
    }

    @GetMapping
    public ResponseEntity<Page<HospitalModel>> getAllHospital(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(hospitalService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneHospital(@PathVariable(value = "id") UUID id){
        Optional<HospitalModel> hospitalModelOptional = hospitalService.findById(id);
        if (!hospitalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital não encontrado !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(hospitalModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHospital(@PathVariable(value = "id") UUID id, @RequestBody @Valid HospitalDto hospitalDto){
    Optional<HospitalModel> hospitalModelOptional = hospitalService.findById(id);
    if (!hospitalModelOptional.isPresent()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital not found");
        }
        var hospitalModel = new HospitalModel();
        BeanUtils.copyProperties(hospitalDto, hospitalModel);
        hospitalModel.setHospital_id(hospitalModelOptional.get().getHospital_id());
        hospitalModel.setRegistrationDate(hospitalModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(hospitalService.save(hospitalModel));
    }

}
