package com.EcommerceInfo2021.Info2021.Entity;

import javax.persistence.*;
import javax.validation.Constraint;
import java.math.BigDecimal;

@Entity
public class Linea {


    /*+ id :long
        + idProducto: long FK producto
        + subtotal: long
        + cantidad: long
        + precioUnitario: long*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinea;
    @Transient
    private BigDecimal subTotal;
    private Long cantidad;
    private Long precioUnitario;
    @ManyToOne
    private Producto producto;
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Long getIdLinea() {
        return idLinea;
    }
}