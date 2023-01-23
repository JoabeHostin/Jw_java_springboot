package com.jw.jw_mecanica.view.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.jw_mecanica.models.Cliente;
import com.jw.jw_mecanica.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController  {
    
    @Autowired
    private ClienteService clienteService;
   
    //#region Métodos
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> getClienteID(@PathVariable long id){
        return clienteService.getClienteID(id);
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable long id) {

            clienteService.deletarCliente(id);
            return "Cliente deletado com sucessos!";           
    }

    @PutMapping("/{id}")
    public Cliente AtualizarCliente( @PathVariable long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    //#endregion
}
