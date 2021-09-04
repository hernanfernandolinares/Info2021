package com.EcommerceInfo2021.Info2021.Controller;

import com.EcommerceInfo2021.Info2021.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
}
