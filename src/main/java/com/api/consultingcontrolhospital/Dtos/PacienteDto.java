package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class PacienteDto {

    @NotBlank(message="Este campo não pode estar em branco.")
    private String nome;
    @NotBlank(message="Este campo não pode estar em branco.")
    private String telefone;
    @NotBlank(message="Este campo não pode estar em branco.")
    private String motivo_referencia;

    @NotBlank(message="Este campo não pode estar em branco.")
    private String tipo_consulta;

    @NotBlank(message="Este campo não pode estar em branco.")
    private UUID hospital;

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

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public UUID getHospital() {
        return hospital;
    }

    public void setHospital(UUID hospital) {
        this.hospital = hospital;
    }
}
