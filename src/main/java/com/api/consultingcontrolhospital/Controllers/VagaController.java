package com.api.consultingcontrolhospital.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge =3600)
@RequestMapping("/consulting-vagas")

public class VagaController {

}