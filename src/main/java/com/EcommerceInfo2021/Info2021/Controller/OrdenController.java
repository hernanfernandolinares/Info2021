package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Dto.OrdenDto;
import com.EcommerceInfo2021.Info2021.Entity.*;
import com.EcommerceInfo2021.Info2021.Repository.LineaOrdenRepository;
import com.EcommerceInfo2021.Info2021.Repository.OrdenRepository;
import com.EcommerceInfo2021.Info2021.Repository.UsuarioRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenController {
    private final OrdenRepository ordenRepository;
    private final LineaOrdenRepository lineaOrdenRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public OrdenController(OrdenRepository ordenRepository, LineaOrdenRepository lineaOrdenRepository, UsuarioRepository usuarioRepository) {
        this.ordenRepository = ordenRepository;
        this.lineaOrdenRepository = lineaOrdenRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarTodasLasOrdenes(@RequestParam(required = false)Long usuarioListar){
        Usuario usuario= usuarioRepository.findById(usuarioListar).orElse(null);
        if(usuario!=null){
            if(!usuario.getOrdens().isEmpty()) {
                return new ResponseEntity<>(ordenRepository.findByUsuario(usuario),HttpStatus.OK);
            }else {
                return new ResponseEntity<>("el usuario no tiene ordenes",HttpStatus.BAD_REQUEST);
            }

        }
        return new ResponseEntity<>(ordenRepository.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> crearOrden(@Valid @RequestBody OrdenDto ordenDto){
        Usuario usuario= usuarioRepository.findById(ordenDto.getUsuarioId()).orElse(null);
        if(usuario!=null){
            if(usuario.getCarritos().isEmpty()){
                return new ResponseEntity<>("no tiene carritos",HttpStatus.BAD_REQUEST);
            }else{
                Carrito ultimoCarrito = usuario.getCarritos().get(usuario.getCarritos().size() - 1);
                if(ultimoCarrito.getEstaActivo()&&!ultimoCarrito.getLineas().isEmpty()){
                    ultimoCarrito.setEstaActivo();
                    Orden orden = ordenRepository.save(new Orden(
                            ordenDto.getObservacion(),
                            ultimoCarrito,
                            usuario
                    ));
                    List<LineaOrden> lineaOrdens= new ArrayList<>();
                    for (Linea linea: ultimoCarrito.getLineas()){
                        Double precio= linea.getProducto().getPrecioUnitario();
                        Long cantidad= linea.getCantidad();
                        Producto producto= linea.getProducto();
                        lineaOrdens.add(new LineaOrden(precio, cantidad, orden,producto));
                    }
                    lineaOrdenRepository.saveAll(lineaOrdens);
                    orden.setLineaOrdens(lineaOrdens);
                    return new ResponseEntity<>(orden,HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("el carrito no esta activo o no tiene productos",HttpStatus.BAD_REQUEST);
                }

            }
        }
        return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarOrdenPorId(@PathVariable("id")Long id){
        Orden orden= ordenRepository.findById(id).orElse(null);
        if(orden!=null){
            return new ResponseEntity<>(orden,HttpStatus.OK);
        }
        return new ResponseEntity<>("no existe la orden del usuario", HttpStatus.NOT_FOUND);
    }

}
