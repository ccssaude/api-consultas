package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class PacienteDto {

    @NotBlank(message="Este campo não pode estar em branco.")
    private String nome;
    @NotBlank(message="Este campo não pode estar em branco.")
    private String telefone;
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

}
