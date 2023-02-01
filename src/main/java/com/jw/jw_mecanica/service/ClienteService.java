package com.jw.jw_mecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.jw_mecanica.shared.ClienteDTO;
import com.jw.jw_mecanica.repository.ClienteRepository;


@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository ClienteService;
     
    /**
     * Método para retornar todos os clientes cadastrados 
     * @return lista de clientes
     */
     
    public List<ClienteDTO> getAllClientes() {
        //Regra entra nesse espaço
        return ClienteService.findAll();
    }

     /**
     * Metodo para retornar um cliente pelo id
     * @param id id do produto a ser retornado
     * @return retorna o produto com o id passado
     */
    public Optional<ClienteDTO> getClienteID(long id) {
        return ClienteService.findById(id);  
    }
    
   /**
     * Metodo para adicionar um cliente
     * @param cliente cliente a ser adicionado     
     * @return retorna o cliente adicionado
     
     */
    public ClienteDTO cadastrarCliente(ClienteDTO cliente) {
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
public ClienteDTO atualizarCliente(Long id, ClienteDTO cliente) {
    cliente.setId(id);
    return ClienteService.save(cliente);
    
}
}
