package com.api.consultingcontrolhospital.Repositories;


import com.api.consultingcontrolhospital.Models.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, UUID> {

}
