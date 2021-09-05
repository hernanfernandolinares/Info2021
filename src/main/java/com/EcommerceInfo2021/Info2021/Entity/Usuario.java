package com.EcommerceInfo2021.Info2021.Entity;

import com.EcommerceInfo2021.Info2021.Util.ValidationHelper;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
   /* + id: long
    + nombre: string
    + apellido: string
    + email: string
    + password: string
    + fechaCreacion: localDate
    + cuidad: string
    + provincia: string
    + pais: string*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no debe ser blanco o nulo")
    private String nombre;
    @NotBlank(message = "El apellido no debe ser blanco o nulo")
    private String apellido;
    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;
    @NotBlank
    @JsonIgnore
    private String password;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @NotBlank
    private String ciudad;
    @NotBlank
    private String provincia;
    @NotBlank
    private String pais;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Carrito> carritos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Orden> ordens;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public String getPassword() {
        return password;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    public List<Orden> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Orden> ordens) {
        this.ordens = ordens;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", carritos=" + carritos +
                ", ordens=" + ordens +
                '}';
    }
}
