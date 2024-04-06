package com.bancarias.demo.Services.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Entitites.Cuentas;
import com.bancarias.demo.Repositorys.ClienteRepository;
import com.bancarias.demo.Repositorys.CuentasRepository;
import com.bancarias.demo.Services.CuentaService;

@Service
public class CuentasServiceImpl implements CuentaService{

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cuentas crearCuentas(Cuentas cuentas) {
        cuentas.setEstado(true);
        cuentas.setFechaApertura(LocalDate.now());

        if(this.cuentasRepository.existsById(cuentas.getNumeroCuenta())){
            return null;
        }
        if(cuentas.getSaldo()<500){
            return null;
            }
        
        //
        return this.cuentasRepository.save(cuentas);
    }

    @Override
    public Cuentas asignarCuentas(String dni, String numeroCuenta) {
        
        if(this.clienteRepository.existsById(dni)){
            if(this.cuentasRepository.existsById(numeroCuenta)){
                
                List<Cuentas> cuentas = new ArrayList<>();
                Cuentas cuenta = this.cuentasRepository.findById(numeroCuenta).get();
                cuentas.add(cuenta);

                Cliente cliente = this.clienteRepository.findById(dni).get();
                if(this.clienteRepository.findByCuentas(cuenta)!= null){
                    cliente.setCuentas(cuentas);
                    this.clienteRepository.save(cliente);
                    return cuenta;
                }


            }
        }
        return null;
    }
    
}
