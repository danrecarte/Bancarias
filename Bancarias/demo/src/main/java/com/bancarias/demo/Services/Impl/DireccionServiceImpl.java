package com.bancarias.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancarias.demo.Entitites.Direccion;
import com.bancarias.demo.Repositorys.DireccionRepository;
import com.bancarias.demo.Services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion, String dni) {
        return this.direccionRepository.save(direccion);
    }
    
}
