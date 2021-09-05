package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Dto.CargaLinea;
import com.EcommerceInfo2021.Info2021.Dto.CarritoDto;
import com.EcommerceInfo2021.Info2021.Entity.Carrito;
import com.EcommerceInfo2021.Info2021.Entity.Linea;
import com.EcommerceInfo2021.Info2021.Entity.Producto;
import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import com.EcommerceInfo2021.Info2021.Repository.CarritoRepository;
import com.EcommerceInfo2021.Info2021.Repository.LineaRepository;
import com.EcommerceInfo2021.Info2021.Repository.ProductoRepository;
import com.EcommerceInfo2021.Info2021.Repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CarritoController {
    private final LineaRepository lineaRepository;
    private final CarritoRepository carritoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public CarritoController(LineaRepository lineaRepository, CarritoRepository carritoRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository) {
        this.lineaRepository = lineaRepository;
        System.out.println("Entrar");
        this.carritoRepository = carritoRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping(value = "/usuario/{id}/carrito")
    public ResponseEntity<?> crearCarrito(@PathVariable("id") Long id, @Valid @RequestBody CarritoDto carrito) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            if(usuario.getCarritos().isEmpty()){
                Carrito newCarrito = new Carrito();
                newCarrito.setUsuario(usuario);
                newCarrito.setGeneradoPor(carrito.getGeneradoPor());
                return new ResponseEntity<>(carritoRepository.save(newCarrito), HttpStatus.CREATED);
            }else{
                Carrito ultimoCarrito = usuario.getCarritos().get(usuario.getCarritos().size() - 1);

                if (!ultimoCarrito.getEstaActivo()) {
                    Carrito newCarrito = new Carrito();
                    newCarrito.setUsuario(usuario);
                    newCarrito.setGeneradoPor(carrito.getGeneradoPor());
                    return new ResponseEntity<>(carritoRepository.save(newCarrito), HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>("Ya tien un carrito Activo", HttpStatus.BAD_REQUEST);
                }
            }
        }

        return new ResponseEntity<>("Usuario no Existe", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value="/usuario/{id}/carrito/{linea}")
        public ResponseEntity<?>eliminarLineaCarritoUsuario(@PathVariable("id")Long id,@PathVariable("linea")Long linea){
        Usuario usuario= usuarioRepository.findById(id).orElse(null);
        Linea linea1= lineaRepository.findById(linea).orElse(null);
        if(usuario!=null){
            if(linea1!=null){
                lineaRepository.delete(linea1);
                return new ResponseEntity<>("Linea Borrada",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Linea no existe", HttpStatus.NOT_FOUND);
            }
        }return new ResponseEntity<>("Usuario no existe",HttpStatus.NOT_FOUND);
    }



    @DeleteMapping(value = "/carrito/{carritoId}")
    public ResponseEntity<?> eleminarCarrito(@PathVariable("carritoId") Long carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElse(null);
        if (carrito != null) {
            if (!carrito.getEstaActivo()) {
                carritoRepository.delete(carrito);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("no se puede elminar un carrito activo", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("no existe el carrito", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/usuario/{id}/carrito")
    public ResponseEntity<?> obtenerCarritoPorId(@PathVariable("id") long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            return new ResponseEntity<>(carritoRepository.findByUsuario(usuario),HttpStatus.OK);
        }
        return new ResponseEntity<>("Usuario no Existe", HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/usuario/{id}/carrito")
    public ResponseEntity<?> agregarProducto(@PathVariable("id")Long id, @Valid @RequestBody CargaLinea linea){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            Producto producto = productoRepository.findById(linea.getProductoId()).orElse(null);
            if (producto!=null&&producto.getPublicado()){
                Carrito ultimoCarrito = usuario.getCarritos().get(usuario.getCarritos().size() - 1);
                if( ultimoCarrito.getEstaActivo()) {
                    Linea linea1 = new Linea();
                    linea1.setCarrito(ultimoCarrito);
                    linea1.setProducto(producto);
                    linea1.setCantidad(linea.getCantidad());
                    return new ResponseEntity<>(lineaRepository.save(linea1),HttpStatus.CREATED);
                }else {
                    return new ResponseEntity<>("El carrito no esta activo ", HttpStatus.NOT_FOUND);}
            }else {
                return new ResponseEntity<>("El producto no Existe o no esta publicado", HttpStatus.NOT_FOUND);}

        }
        return new ResponseEntity<>("Usuario no Existe", HttpStatus.NOT_FOUND);
    }
}

