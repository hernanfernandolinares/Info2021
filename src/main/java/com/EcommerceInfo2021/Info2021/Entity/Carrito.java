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
    private Boolean estado;
    private generado generadoPor;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;
    @Transient
    private BigDecimal subTotal;
    @Column(name = "Ativo")
    @NotBlank
    private boolean estaActivo;
    @ManyToOne
    @JoinColumn(name = "usuario")
    Usuario usuario;
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Linea> lineas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public generado getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(generado generadoPor) {
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

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
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

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", estado=" + estado +
                ", generadoPor=" + generadoPor +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", fechaUltimaModificacion=" + fechaUltimaModificacion +
                ", subTotal=" + subTotal +
                ", usuario=" + usuario +
                ", lineas=" + lineas +
                '}';
    }
}
