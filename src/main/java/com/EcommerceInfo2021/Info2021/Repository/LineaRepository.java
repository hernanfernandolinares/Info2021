package com.EcommerceInfo2021.Info2021.Repository;

import com.EcommerceInfo2021.Info2021.Entity.Linea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaRepository extends CrudRepository<Linea, Long> {
}