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
    private UUID id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 50)
    private Integer vagas_dispo;

    @Column(nullable = true, length = 55)
    private Date Data_consulta;

    @OneToMany
    private List<PacienteModel> pacientes;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Date getData_consulta() {
        return Data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        Data_consulta = data_consulta;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}