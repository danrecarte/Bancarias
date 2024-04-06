package com.bancarias.demo.DTOS;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bancarias.demo.Entitites.Cuentas;

import lombok.Data;

@Component
@Data
public class ClienteDTO {
    
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private List<Cuentas> listCuentas;

}
