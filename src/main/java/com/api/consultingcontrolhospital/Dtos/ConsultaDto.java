package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ConsultaDto {
    @NotBlank
    private String nome;
    @NotBlank
    @Size(max = 55)
    private String tipo_consulta;
//    @NotBlank
//    private UUID paciente_id;
//    @NotBlank
//    private UUID hospital_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }
}
