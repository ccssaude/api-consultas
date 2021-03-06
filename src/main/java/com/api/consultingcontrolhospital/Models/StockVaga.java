package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class StockVaga {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private Integer Quantidade;

    @OneToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital_id;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }

    public Hospital getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Hospital hospital_id) {
        this.hospital_id = hospital_id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
