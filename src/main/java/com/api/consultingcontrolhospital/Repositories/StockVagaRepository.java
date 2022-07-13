package com.api.consultingcontrolhospital.Repositories;

import com.api.consultingcontrolhospital.Models.Paciente;
import com.api.consultingcontrolhospital.Models.StockVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockVagaRepository  extends JpaRepository<Paciente, Integer> {
//  @Query(value = "SELECT  FROM paciente where hospital_id = hospital_id and data_consulta = data_consulta");
//    @Param("hospital_id") Integer status,
//    @Param("data_consulta") String name);

}
