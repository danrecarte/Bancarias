package com.bancarias.demo.Services;

import com.bancarias.demo.Entitites.Cuentas;

public interface CuentaService {
    
    public Cuentas crearCuentas(Cuentas cuentas);
    public Cuentas asignarCuentas(String dni, String numeroCuenta);

}
