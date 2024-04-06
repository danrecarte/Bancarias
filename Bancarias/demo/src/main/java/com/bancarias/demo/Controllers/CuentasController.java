package com.bancarias.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancarias.demo.Entitites.Cuentas;
import com.bancarias.demo.Services.Impl.CuentasServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/Cuentas")
public class CuentasController {
    @Autowired
    private CuentasServiceImpl cuentasServiceImpl;

    @PostMapping("/crear")
    public Cuentas crearCuentas(@RequestBody Cuentas cuentas) {
        return this.cuentasServiceImpl.crearCuentas(cuentas);
    }
    
    @PutMapping("/asignar/{dni}")
    public Cuentas asignarCuentas(@PathVariable String dni, @RequestParam String numeroCuenta) {
        return this.cuentasServiceImpl.asignarCuentas(dni, numeroCuenta);
    }

}
