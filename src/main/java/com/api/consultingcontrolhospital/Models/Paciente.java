package com.api.consultingcontrolhospital.Models;

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
    private UUID id;
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String telefone;

    @Column(nullable = false, length = 50)
    private String motivo_referencia;

    @Column(nullable = true, length = 100)
    private String tipo_consulta;

    @Column(nullable = true, length = 55)
    private LocalDateTime Data_ref;

    @Column(nullable = true, length = 55)
    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date Data_consulta;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name="hospital_id", nullable = true)
    private Hospital hospital_id;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMotivo_referencia() {
        return motivo_referencia;
    }

    public void setMotivo_referencia(String motivo_referencia) {
        this.motivo_referencia = motivo_referencia;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public LocalDateTime getData_ref() {
        return Data_ref;
    }

    public void setData_ref(LocalDateTime data_ref) {
        Data_ref = data_ref;
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

    public Hospital getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Hospital hospital_id) {
        this.hospital_id = hospital_id;
    }
}