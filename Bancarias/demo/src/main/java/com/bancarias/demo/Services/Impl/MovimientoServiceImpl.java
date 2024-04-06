package com.bancarias.demo.Services.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Entitites.Cuentas;
import com.bancarias.demo.Entitites.Movimientos;
import com.bancarias.demo.Repositorys.ClienteRepository;
import com.bancarias.demo.Repositorys.CuentasRepository;
import com.bancarias.demo.Repositorys.MovimientosRepository;
import com.bancarias.demo.Services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Movimientos crearMovimientos(Movimientos movimientos) {
        Cuentas cuentas = this.cuentasRepository.findById(movimientos.getNumeroCuenta()).get();
        if(this.cuentasRepository.existsById(movimientos.getNumeroCuenta())){
            if(this.cuentasRepository.findById(movimientos.getNumeroCuenta()).get().isEstado()){

                if(movimientos.getTipoMovimiento()== 'C'){
                    double saldo = cuentas.getSaldo();
                    cuentas.setSaldo(saldo + movimientos.getMonto());
                    movimientos.setFechaMovimiento(LocalDate.now());
                    
                    this.cuentasRepository.save(cuentas);

                    return this.movimientosRepository.save(movimientos);

                }
                if(movimientos.getTipoMovimiento() == 'D'){
                    double saldo = cuentas.getSaldo();
                    if(saldo>movimientos.getMonto()){
                        cuentas.setSaldo(saldo - movimientos.getMonto());
                        movimientos.setFechaMovimiento(LocalDate.now());
                        
                        this.cuentasRepository.save(cuentas);

                        return this.movimientosRepository.save(movimientos);

                    }else{
                        if(cuentas.isSobregiro()){
                            cuentas.setSaldo(saldo - movimientos.getMonto());
                            movimientos.setFechaMovimiento(LocalDate.now());
                           
                            
                            this.cuentasRepository.save(cuentas);

                            return this.movimientosRepository.save(movimientos);
                        }
                    }
                    
                    
                }




            }
        }
        return null;
    }


    @Override
    public Cliente obtenerMovimientosPorCuenta(String numeroCuenta) {
        Cuentas cuentas = this.cuentasRepository.findById(numeroCuenta).get();
        Cliente cliente = this.clienteRepository.findByCuentas(cuentas);
        return cliente;
        
    }

    
    
}
