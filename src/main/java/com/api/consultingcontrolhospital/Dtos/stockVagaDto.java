package com.api.consultingcontrolhospital.Dtos;

import javax.validation.constraints.NotBlank;

public class stockVagaDto {

    @NotBlank(message="Este campo não pode estar em branco.")
    private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
