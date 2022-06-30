package com.api.consultingcontrolhospital.Models;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_VAGA")
public class vagaModel implements Serializable {
    private static final long serialVerionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 15)
    private Boolean quantidade;
    @Column(nullable = false, length = 5)
    private String nome;
    @Column(nullable = false)
    private LocalDateTime registrationDate;





}
