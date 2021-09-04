package com.EcommerceInfo2021.Info2021.Repository;

import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByFechaDeCreacionAfter(LocalDateTime dateTime);

    List<Usuario> findByFechaDeCreacionBetween(LocalDateTime desde, LocalDateTime hasta);

    List<Usuario> findByNombreContainingAndApellidoContainingAndPaisContainingAndProvinciaContainingAndCiudadContaining
            (String nombre, String apellido, String pais,String provincia, String ciudad);


}
