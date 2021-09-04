package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Entity.Producto;
import com.EcommerceInfo2021.Info2021.Exception.CarritoException;
import com.EcommerceInfo2021.Info2021.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@Valid @RequestBody Producto producto) throws CarritoException {
        return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> buscarProducto(@RequestParam("comienzaCon") String comienzaCon) throws CarritoException {
        return new ResponseEntity<>(productoRepository.buscarPorNombreQueComienza(comienzaCon), HttpStatus.CREATED);
    }
}
