package com.EcommerceInfo2021.Info2021.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.SpringVersion;

import javax.persistence.*;

@Entity
public class LineaOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precio;
    private Long cantidad;
    @Transient
    private Double subTotal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        subTotal= precio*cantidad;
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
