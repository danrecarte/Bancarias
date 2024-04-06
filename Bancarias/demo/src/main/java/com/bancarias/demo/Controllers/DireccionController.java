package com.bancarias.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancarias.demo.Entitites.Direccion;
import com.bancarias.demo.Services.Impl.DireccionServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/api/Direccion")
@RestController
public class DireccionController {
    
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/crear")
    public Direccion crearDireccion(@RequestBody Direccion direccion, String dni) {
        return this.direccionServiceImpl.crearDireccion(direccion, dni);
    }
    

}
