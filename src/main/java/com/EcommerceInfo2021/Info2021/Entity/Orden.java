package com.EcommerceInfo2021.Info2021.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
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
    private boolean estaActivo;


}
