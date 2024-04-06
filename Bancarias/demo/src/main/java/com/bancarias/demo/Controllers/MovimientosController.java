package com.bancarias.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Entitites.Movimientos;
import com.bancarias.demo.Services.Impl.MovimientoServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/Movimientos")
public class MovimientosController {
    
    @Autowired
    private MovimientoServiceImpl movimientoServiceImpl;

    @PostMapping("/crear")
    public Movimientos crearMovimientos(@RequestBody Movimientos movimientos) {
        return this.movimientoServiceImpl.crearMovimientos(movimientos);
    }
    

    @GetMapping("/obtener")
    public Cliente obtenerMovimientosPorCuenta(@RequestParam String numeroCuenta) {
        return this.movimientoServiceImpl.obtenerMovimientosPorCuenta(numeroCuenta);
    }
    

}
