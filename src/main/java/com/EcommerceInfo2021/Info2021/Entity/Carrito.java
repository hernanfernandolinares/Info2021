package com.EcommerceInfo2021.Info2021.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private Long idCarrito;
    private Boolean estado;
    private generado generadoPor;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;
    @Transient
    private BigDecimal subTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    Carrito carrito;
    @ManyToOne(fetch = FetchType.LAZY)
    Usuario usuario;
    @OneToMany(mappedBy = "idLinea",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Linea> lineas = new ArrayList<>();

    public Long getIdCarrito() {
        return idCarrito;
    }

    public List<Linea> getLineas() {
        return lineas;
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
}
