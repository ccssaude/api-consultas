package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PACIENTE")
public class PacienteModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paciente_id;
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
    private Date Data_consulta;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name="paciente_id")
    private PacienteModel pacientes;

    public UUID getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(UUID paciente_id) {
        this.paciente_id = paciente_id;
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

    public PacienteModel getPacientes() {
        return pacientes;
    }

    public void setPacientes(PacienteModel pacientes) {
        this.pacientes = pacientes;
    }
}