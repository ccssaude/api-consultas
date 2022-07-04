package com.api.consultingcontrolhospital.Repositories;

import com.api.consultingcontrolhospital.Models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRespository extends JpaRepository<PacienteModel, UUID> {
}
