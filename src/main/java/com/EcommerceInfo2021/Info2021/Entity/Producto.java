package com.EcommerceInfo2021.Info2021.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Producto {


    /*+ id :long
        + nombre: string
        + descripcion: string
        + precioUnicatario: long
        + contenido: string
        + fechaCreacion: localDate
        + publicado: boolean*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    private String descripcion;
    @NotNull
    private Double precioUnitario;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    private Boolean publicado;
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Linea> lineas;
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = false)
    List<LineaOrden> lineaOrdensM;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto() {
    }

   public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", contenido='" + contenido + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", publicado=" + publicado +
                ", lineas=" + lineas +
                '}';
    }
}
