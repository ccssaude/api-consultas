package com.api.consultingcontrolhospital.Dtos;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class HospitalDto {

    @NotBlank(message="Este campo não pode estar em branco.")
    private String nome;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
