package com.api.consultingcontrolhospital.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class Paciente implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String telefone;

    @Column(nullable = true, length = 55)
    private LocalDateTime Data_ref;
    //@DateTimeFormat(pattern="EEE dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    //if there is bug on jdbc tables generating please comment the line below with DATETIME
    @Column(name = "data_consulta", columnDefinition = "DATETIME")
    private Date data_consulta;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="hospital_id", nullable = true)
    private Hospital hospital_id;

    public Paciente() {
    }

    public Paciente(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getData_ref() {
        return Data_ref;
    }

    public void setData_ref(LocalDateTime data_ref) {
        Data_ref = data_ref;
    }

    public Date getData_consulta() {
        return data_consulta;
    }
    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Hospital getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Hospital hospital_id) {
        this.hospital_id = hospital_id;
    }
}