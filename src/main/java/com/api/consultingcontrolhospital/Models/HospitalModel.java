package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "TB_HOSPITAL")
public class HospitalModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hospital_id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = true, length = 50)
    private Integer vagas_dispo;

    @OneToMany(mappedBy="pacientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PacienteModel> pacientes;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public UUID getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(UUID hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas_dispo() {
        return vagas_dispo;
    }

    public void setVagas_dispo(Integer vagas_dispo) {
        this.vagas_dispo = vagas_dispo;
    }

    public Set<PacienteModel> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<PacienteModel> pacientes) {
        this.pacientes = pacientes;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}