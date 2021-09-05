package com.EcommerceInfo2021.Info2021.Repository;

import com.EcommerceInfo2021.Info2021.Entity.Orden;
import com.EcommerceInfo2021.Info2021.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Long> {
    Iterable<?>findByUsuario(Usuario usuario);
}