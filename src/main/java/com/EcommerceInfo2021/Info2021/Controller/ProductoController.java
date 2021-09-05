package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Entity.Producto;
import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import com.EcommerceInfo2021.Info2021.Exception.CarritoException;
import com.EcommerceInfo2021.Info2021.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
        @PostMapping
    public ResponseEntity<?> createProducto(@Valid @RequestBody Producto producto) throws CarritoException {
        return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.CREATED);
    }
    @DeleteMapping(value = { "/{id}" })
    public void eleminarProductoPorId(@PathVariable("id")Long id){
        productoRepository.deleteById(id);
    }


    @GetMapping
    public ResponseEntity<?> obtenerTodosLosProductos(
            @RequestParam(name = "nombre", required = false) String nombre){
        if(nombre!=null) {
            return new ResponseEntity<>(productoRepository.findAllByNombreContaining(nombre),HttpStatus.OK);
        }
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = { "/{id}" })
    public Producto obtenerProductoPorId(@PathVariable ("id")long id){
        return productoRepository.findById(id).get();
    }
    @GetMapping(value = {"/noPublicado"})
    public ResponseEntity<?> noPublicado() {
        return new  ResponseEntity<>(productoRepository.findAllByPublicadoFalse(),HttpStatus.OK);
    }
    @PutMapping(value = { "/{id}" })
    public Producto modificarProductoPorId(@PathVariable("id")long id, @Valid @RequestBody Producto producto){
        Producto productoExiste= productoRepository.findById(id).get();
        productoExiste.setNombre(producto.getNombre());
        productoExiste.setDescripcion(producto.getDescripcion());
        productoExiste.setPrecioUnitario(producto.getPrecioUnitario());
        productoExiste.setContenido(producto.getContenido());
        productoExiste.setPublicado(producto.getPublicado());
        return productoRepository.save(productoExiste);
    }
}
