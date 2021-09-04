package com.EcommerceInfo2021.Info2021.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orden {
    /*+ id :long
    + idCarrito: long FK carrito
    + detalleCompra: lineas fk linea
    + fechaCreacion: localDate
    + observacion: string(200)
    + estaActivo: boolean
    + idUsuario: long FK usuario*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Max(200)
    private String observacion;
    @Column(name = "Ativo")
    @NotBlank
    private boolean estaActivo;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrito")
    private Carrito carrito;
    @ManyToOne
    Usuario usuario;
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Linea> lineas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Orden() {
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estaActivo=" + estaActivo +
                ", carrito=" + carrito +
                ", usuario=" + usuario +
                '}';
    }
}
