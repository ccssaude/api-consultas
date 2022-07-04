package com.api.consultingcontrolhospital.Dtos;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class HospitalDto {

    @NotBlank
    private String nome;
    @NotNull
    private Integer vagas_dispo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas_dispo() {
        return vagas_dispo;
    }

    public void setVagas_dispo(Integer vagas_dispo) {
        this.vagas_dispo = vagas_dispo;
    }
}
