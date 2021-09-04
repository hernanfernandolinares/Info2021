package com.EcommerceInfo2021.Info2021.Entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    private Long idProducto;
    @NotNull
    private String nombre;
    private String descripcion;
    @NotNull
    private Long precioUnitario;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    private Boolean publicado;


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

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
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

    public Long getIdProducto() {
        return idProducto;
    }
}
