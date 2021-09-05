package com.EcommerceInfo2021.Info2021.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Carrito {
    /*+ id :long
   + generadoPor:[M | W | S]
   + idUsuario: long FK usuario
   + fechaCreacion: localDate
   + fechaUltimaModificacion: localDate
   + subTotal: bigdecimal
   + idlinea: idLinea FK linea
   + estado: boolean*/
    public enum generado{mobile, web, servicio}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String generadoPor; //M W
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;
    @Transient
    private Double total;
    @Column(name = "Ativo")
    private boolean estaActivo= true;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Linea> lineas=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo() {
        this.estaActivo = false;
    }

    public String getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public Double getTotal() {
        total=0.0;
        for (Linea linea:lineas) {
            total+=linea.getSubTotal();
        }
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Carrito() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

}
