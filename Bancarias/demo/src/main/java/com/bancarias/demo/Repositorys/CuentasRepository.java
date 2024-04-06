package com.bancarias.demo.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bancarias.demo.Entitites.Cuentas;

@Repository
public interface CuentasRepository extends CrudRepository<Cuentas,String>{
    
}
