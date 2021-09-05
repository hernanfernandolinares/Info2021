package com.EcommerceInfo2021.Info2021.Repository;

import com.EcommerceInfo2021.Info2021.Entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
    Iterable<Producto> findAllByNombreContaining(String nombre);
    Iterable<Producto> findAllByPublicadoFalse();

}
