package com.bancarias.demo.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancarias.demo.DTOS.ClienteDTO;
import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Entitites.Cuentas;
import com.bancarias.demo.Repositorys.ClienteRepository;
import com.bancarias.demo.Repositorys.CuentasRepository;
import com.bancarias.demo.Services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    public Cliente crearClliente1(ClienteDTO clienteDTO) {

        //Hecho asi por si de hecho el flujo era al reves

        Cliente cliente = new Cliente();
        if(this.clienteRepository.existsById(clienteDTO.getDni())){
            return null;
        }
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setDni(clienteDTO.getDni());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setTelefono(clienteDTO.getTelefono());

        List<Cuentas> listCuentas = clienteDTO.getListCuentas();
        this.cuentasRepository.saveAll(listCuentas);

        return this.clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerCliente(String dni) {
        return this.clienteRepository.findById(dni).orElse(null);
    }

    @Override
    public Cliente crearClliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }
    
}
