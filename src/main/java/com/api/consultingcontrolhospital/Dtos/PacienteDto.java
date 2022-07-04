package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;

public class PacienteDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String motivo_referencia;

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
}
