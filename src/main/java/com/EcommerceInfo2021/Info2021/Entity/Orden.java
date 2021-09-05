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
    @Transient
    private Double total;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrito")
    private Carrito carrito;
    @ManyToOne
    Usuario usuario;
    @OneToMany(mappedBy = "orden")
    private List<LineaOrden> lineaOrdens=new ArrayList<>();

    public Orden(String observacion, Carrito carrito, Usuario usuario) {
        this.observacion = observacion;
        this.carrito = carrito;
        this.usuario = usuario;
    }

    public List<LineaOrden> getLineaOrdens() {
        return lineaOrdens;
    }

    public void setLineaOrdens(List<LineaOrden> lineaOrdens) {
        this.lineaOrdens = lineaOrdens;
    }

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

    public Double getTotal() {
        total=0.0;
        for (LineaOrden linea:lineaOrdens) {
            total+=linea.getSubTotal();
        }
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
