package com.bancarias.demo.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bancarias.demo.Entitites.Movimientos;

@Repository
public interface MovimientosRepository extends CrudRepository<Movimientos,Integer>{
    
}
