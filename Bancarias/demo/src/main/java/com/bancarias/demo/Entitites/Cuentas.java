package com.bancarias.demo.Entitites;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cuentas")
@Data
public class Cuentas {
    
    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

   // @ManyToOne
    //@JoinColumn(name="dni",referencedColumnName = "dni")
    //private Cliente cliente;

    private double saldo;

    //private String dni;

    @Column(name = "fechaapertura")
    private LocalDate fechaApertura;

    private boolean estado;

    private boolean sobregiro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmovimiento", referencedColumnName = "idmovimiento")
    private List<Movimientos> movimientos;
}
