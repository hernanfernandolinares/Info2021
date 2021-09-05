package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Entity.LineaOrden;
import com.EcommerceInfo2021.Info2021.Repository.LineaOrdenRepository;
import com.EcommerceInfo2021.Info2021.Repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/orden")
public class OrdenController {
    private final OrdenRepository ordenRepository;
    private final LineaOrdenRepository lineaOrdenRepository;
    @Autowired
    public OrdenController(OrdenRepository ordenRepository, LineaOrdenRepository lineaOrdenRepository) {
        this.ordenRepository = ordenRepository;
        this.lineaOrdenRepository = lineaOrdenRepository;
    }
    @GetMapping
    public Iterable<?> listarTodasLasOrdenes(){
        return ordenRepository.findAll();
    }

}
