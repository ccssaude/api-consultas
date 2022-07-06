package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_PACIENTE")
public class PacienteModel implements Serializable {
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

    @Column(nullable = true, length = 55)
    private Date Data_consulta;

    @Column(nullable = true, length = 55)
    private LocalDateTime Data_ref;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    private HospitalModel hospital_id;

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

    public Date getData_consulta() {
        return Data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        Data_consulta = data_consulta;
    }

    public LocalDateTime getData_ref() {
        return Data_ref;
    }

    public void setData_ref(LocalDateTime data_ref) {
        Data_ref = data_ref;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public HospitalModel getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(HospitalModel hospital_id) {
        this.hospital_id = hospital_id;
    }
}