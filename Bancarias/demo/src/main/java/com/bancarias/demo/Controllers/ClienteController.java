package com.bancarias.demo.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancarias.demo.DTOS.ClienteDTO;
import com.bancarias.demo.Entitites.Cliente;
import com.bancarias.demo.Services.Impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearClliente(cliente);
    }
    
    @GetMapping("/obtenerTodos")
    public List<Cliente> obtenerTodosClientes() {
        return this.clienteServiceImpl.obtenerTodosClientes();
    }

    @GetMapping("/obtener/{dni}")
    public Cliente obtenerCliente(@PathVariable String dni) {
        return this.clienteServiceImpl.obtenerCliente(dni);
    }
    
    

}
