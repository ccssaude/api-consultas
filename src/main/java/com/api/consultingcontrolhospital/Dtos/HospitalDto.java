package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;

public class HospitalDto {

    @NotBlank
    private String nome;
    @NotBlank
    private Boolean vagas_dispo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getVagas_dispo() {
        return vagas_dispo;
    }

    public void setVagas_dispo(Boolean vagas_dispo) {
        this.vagas_dispo = vagas_dispo;
    }
}
