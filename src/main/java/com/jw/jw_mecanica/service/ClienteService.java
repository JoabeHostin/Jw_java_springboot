package com.jw.jw_mecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.jw_mecanica.models.Cliente;
import com.jw.jw_mecanica.repository.ClienteRepository;


@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository ClienteService;
     
    /**
     * Método para retornar todos os clientes cadastrados 
     * @return lista de clientes
     */
     
    public List<Cliente> getAllClientes() {
        //Regra entra nesse espaço
        return ClienteService.findAll();
    }

     /**
     * Metodo para retornar um cliente pelo id
     * @param id id do produto a ser retornado
     * @return retorna o produto com o id passado
     */
    public Optional<Cliente> getClienteID(long id) {
        return ClienteService.findById(id);  
    }
    
   /**
     * Metodo para adicionar um cliente
     * @param cliente cliente a ser adicionado     
     * @return retorna o cliente adicionado
     
     */
    public Cliente cadastrarCliente(Cliente cliente) {
        return ClienteService.save(cliente);
    }

  /**
     * Metodo para deletar um cliente
     * @param id id do cliente a ser deletado
     */
    public void deletarCliente(long id) {
        ClienteService.deleteById(id);
    }

    /**
 * Metodo para atualizar um cliente
 * @param cliente cliente a ser atualizado
 * @return retorna o cliente atualizado
 */
public Cliente atualizarCliente(Long id, Cliente cliente) {
    cliente.setId(id);
    return ClienteService.save(cliente);
    
}
}
