package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_CONSULTA")
public class ConsultaModel implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @Column(name = "consulta_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false, length = 25)
    private String tipo_consulta;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private PacienteModel pacienteModel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaga_id")
    private VagaModel vagaModel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private HospitalModel hospitalModel;

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

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
