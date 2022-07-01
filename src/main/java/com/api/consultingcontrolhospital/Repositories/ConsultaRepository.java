package com.api.consultingcontrolhospital.Repositories;

import com.api.consultingcontrolhospital.Models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, UUID> {

}
