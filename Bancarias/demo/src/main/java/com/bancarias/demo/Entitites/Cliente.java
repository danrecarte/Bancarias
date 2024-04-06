package com.bancarias.demo.Entitites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    
    @Id
    private String dni;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numerocuenta")
    private List<Cuentas> cuentas;

    @OneToMany
    @JoinColumn(name = "iddireccion", referencedColumnName = "iddireccion")
    private List<Direccion> direcciones;


    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

}
