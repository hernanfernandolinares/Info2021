package com.EcommerceInfo2021.Info2021.Entity;

import javax.persistence.*;
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

    private String observacion;
    private boolean estaActivo;


}
