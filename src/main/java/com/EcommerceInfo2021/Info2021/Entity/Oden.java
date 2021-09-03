package com.EcommerceInfo2021.Info2021.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Oden {
    /*+ id :long
    + idCarrito: long FK carrito
    + detalleCompra: lineas fk linea
    + fechaCreacion: localDate
    + observacion: string(200)
    + estaActivo: boolean
    + idUsuario: long FK usuario*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;
    @OneToMany( mappedBy = "idLinea",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Linea> lineas = new ArrayList<>();
    @OneToOne
    private Carrito carrito;
    private String observacion;
    private boolean estaActivo;
    @OneToOne
    private Usuario usuario;

}
