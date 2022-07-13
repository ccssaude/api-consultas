package com.api.consultingcontrolhospital.Repositories;


import com.api.consultingcontrolhospital.Models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
