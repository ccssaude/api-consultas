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
//  private Date Data_consulta;
    private String Data_consulta;

    @Column(nullable = true, length = 55)
    private LocalDateTime Data_ref;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private HospitalModel hospital;

    @ManyToOne
    private HospitalModel hospitall;

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

    public String getData_consulta() {
        return Data_consulta;
    }

    public void setData_consulta(String data_consulta) {
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

    public HospitalModel getHospital() {
        return hospital;
    }

    public void setHospital(HospitalModel hospital) {
        this.hospital = hospital;
    }

    public HospitalModel getHospitall() {
        return hospitall;
    }

    public void setHospitall(HospitalModel hospitall) {
        this.hospitall = hospitall;
    }
}
