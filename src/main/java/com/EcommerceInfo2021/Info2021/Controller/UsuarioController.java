package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import com.EcommerceInfo2021.Info2021.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping(value = { "/{id}" })
    public Usuario obtenerUsurioPorId(@PathVariable ("id")long id){
        return usuarioRepository.findById(id).get();
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<?> modificarUsuarioPorId(@PathVariable("id")long id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioExiste= usuarioRepository.findById(id).get();
        if(usuarioExiste!=null){
            usuarioExiste.setNombre(usuario.getNombre());
            usuarioExiste.setApellido(usuario.getApellido());
            usuarioExiste.setPassword(usuario.getPassword());
            usuarioExiste.setPais(usuario.getPais());
            usuarioExiste.setCiudad(usuario.getCiudad());
            usuarioExiste.setProvincia(usuario.getProvincia());
            usuarioExiste.setEmail(usuario.getEmail());
            return new ResponseEntity<>(usuarioRepository.save(usuarioExiste),HttpStatus.OK);
        }
        return new ResponseEntity<>("el usuario no existe",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = { "/{id}" })
    public void eleminarUsuarioPorId(@PathVariable("id")Long id){
        usuarioRepository.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(
            @RequestParam(name = "fechaDeCreacion", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion,
            @RequestParam(name = "ciudad", required = false) String ciudad)
            {
        if (fechaDeCreacion != null) {
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atStartOfDay()), HttpStatus.OK);
        }
        if(ciudad != null) {
            return new ResponseEntity<>(usuarioRepository.findByCiudadContaining(ciudad), HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }
}
