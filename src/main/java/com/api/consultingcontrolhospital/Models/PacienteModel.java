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

    @Column(nullable = false, length = 55)
    private Date Data_consulta;

    @Column(nullable = false, length = 55)
    private Date Data_ref;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private HospitalModel hospital;

    @ManyToOne
    private HospitalModel hospitall;

}
