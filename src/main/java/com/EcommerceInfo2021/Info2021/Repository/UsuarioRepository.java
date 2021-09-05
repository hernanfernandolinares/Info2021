package com.EcommerceInfo2021.Info2021.Repository;

import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByFechaDeCreacionAfter(LocalDateTime dateTime);

    List<Usuario> findByCiudadContaining(String ciudad);

    Usuario findById(String id);

    }
