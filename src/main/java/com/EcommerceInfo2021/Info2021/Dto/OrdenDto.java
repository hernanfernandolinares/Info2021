package com.EcommerceInfo2021.Info2021.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdenDto {
    @NotBlank
    private String observacion;
    @NotNull
    private Long usuarioId;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
