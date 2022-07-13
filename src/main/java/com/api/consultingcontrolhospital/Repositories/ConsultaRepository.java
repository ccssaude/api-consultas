package com.api.consultingcontrolhospital.Repositories;

import com.api.consultingcontrolhospital.Models.Consulta;
import com.api.consultingcontrolhospital.Models.Hospital;
import com.api.consultingcontrolhospital.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<Paciente, Integer> {
    @Query(value = "SELECT new Paciente(c.id,c.nome, c.telefone) FROM Paciente AS c where c.hospital_id =:hospital and c.data_consulta=:cdate")
    List<Paciente> pacientesMarcados( @Param("hospital") Hospital hospital,
                                           @Param("cdate") Date cdate);
}