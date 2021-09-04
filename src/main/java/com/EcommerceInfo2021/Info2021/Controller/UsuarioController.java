package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import com.EcommerceInfo2021.Info2021.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping (value = "/usuario")
    public Usuario createUusuario(@RequestBody Usuario usuario){return usuarioRepository.save(usuario);}
   /* @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(
            @RequestParam(name = "fechaDeCreacion", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "apellido", required = false) String apellido,
            @RequestParam(name = "pais", required = false) String pais,
            @RequestParam(name = "provincia", required = false) String provincia,
            @RequestParam(name = "ciudad", required = false) String ciudad) {
        if (fechaDeCreacion != null) {
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atStartOfDay()), HttpStatus.OK);
        } else if (Objects.nonNull(nombre) && Objects.nonNull(apellido) && Objects.nonNull(pais) && Objects.nonNull(provincia) && Objects.nonNull(ciudad)) {
            return new ResponseEntity<>(usuarioRepository.findByNombreContainingAndApellidoContainingAndPaisContainingAndProvinciaContainingAndCiudadContaining(nombre, apellido, pais, provincia,ciudad), HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }*/
}
