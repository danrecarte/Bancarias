package com.bancarias.demo.Services;

import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Entitites.Movimientos;

public interface MovimientoService {
    public Movimientos crearMovimientos(Movimientos movimientos);
    public Cliente obtenerMovimientosPorCuenta(String numeroCuenta);
}
