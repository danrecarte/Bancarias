package com.bancarias.demo.Services;

import java.util.List;

import com.bancarias.demo.DTOS.ClienteDTO;
import com.bancarias.demo.Entitites.Cliente;

public interface ClienteService {
    
    public Cliente crearClliente1(ClienteDTO clienteDTO);
    public Cliente crearClliente(Cliente cliente);
    public List<Cliente> obtenerTodosClientes();
    public Cliente obtenerCliente(String dni);

}
