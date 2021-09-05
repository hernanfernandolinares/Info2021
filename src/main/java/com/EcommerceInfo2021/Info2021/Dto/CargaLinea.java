package com.EcommerceInfo2021.Info2021.Dto;


import javax.validation.constraints.NotNull;

public class CargaLinea {
    @NotNull
    private Long productoId;
    @NotNull
    private Long cantidad;

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
