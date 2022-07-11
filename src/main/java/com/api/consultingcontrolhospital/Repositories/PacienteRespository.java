package com.api.consultingcontrolhospital.Repositories;

import com.api.consultingcontrolhospital.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRespository extends JpaRepository<Paciente, UUID> {

}
