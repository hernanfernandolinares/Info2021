package com.EcommerceInfo2021.Info2021.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Long id;
    @Transient
    private Double subTotal;
    private Long cantidad;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carrito")
    Carrito carrito;
    @ManyToOne
    @JoinColumn
    Producto producto;

    public Double getSubTotal() {
        subTotal= producto.getPrecioUnitario()*cantidad;
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Linea() {
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Linea{" +
                "id=" + id +
                ", subTotal=" + subTotal +
                ", cantidad=" + cantidad +
                ", carrito=" + carrito +
                ", producto=" + producto +
                '}';
    }
}
