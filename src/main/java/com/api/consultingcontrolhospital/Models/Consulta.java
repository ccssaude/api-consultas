package com.api.consultingcontrolhospital.Models;

import javax.persistence.*;

@Entity
public class Consulta {

        private static final long serialVersionUID =1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String data_disponivel;

        @Column(nullable = false, length = 100)
        private Integer hospitalid;

    public Consulta(String data_disponivel, Integer hospitalid) {
        this.data_disponivel = data_disponivel;
        this.hospitalid = hospitalid;
    }
    public String getData_disponivel() {
            return data_disponivel;
        }

        public void setData_disponivel(String data_disponivel) {
            this.data_disponivel = data_disponivel;
        }

        public Integer getHospitalid() {
            return hospitalid;
        }

        public void setHospitalid(Integer hospitalid) {
            this.hospitalid = hospitalid;
        }

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
