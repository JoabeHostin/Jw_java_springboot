package com.jw_mecanica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jw_mecanica.shared.ClienteDTO;
import com.jw_mecanica.models.Cliente;
import com.jw_mecanica.models.exception.ResourceNotFoundException;
import com.jw_mecanica.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Método para retornar todos os clientes cadastrados
     * 
     * @return lista de clientes
     */

    public List<ClienteDTO> getAllClientes() {
        // Regra entra nesse espaço
        List<Cliente> cliente = clienteRepository.findAll();

        return cliente.stream().map(Cliente -> new ModelMapper().map(Cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo para retornar um cliente pelo id
     * 
     * @param id id do produto a ser retornado
     * @return retorna o produto com o id passado
     */
    public Optional<ClienteDTO> getClienteID(long id) {
        // Cria um optional de cliente por id
        Optional<Cliente> cliente = clienteRepository.findById(id);
        // transforma o optional em um cliente dto
        ClienteDTO dto = new ModelMapper().map(cliente.get(), ClienteDTO.class);
        return Optional.of(dto);
    }

    /**
     * Metodo para adicionar um cliente
     * 
     * @param cliente cliente a ser adicionado
     * @return retorna o cliente adicionado
     */
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        clienteDTO.setId(null);

        // Criar mapeamento
        ModelMapper mapper = new ModelMapper();
        // Converter nosso ClienteDTO em um Cliente.
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        // Salvar Cliente no banco
        cliente = clienteRepository.save(cliente);
        clienteDTO.setId(cliente.getId());
        // Retornar produto cadastrado
        return clienteDTO;

    }

    /**
     * Metodo para deletar um cliente
     * 
     * @param id id do cliente a ser deletado
     */
    public void deletarCliente(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("Não Foi possivel deletar o cliente desejado"
                    + " o mesmo não se encontra disponivel");
        }
        clienteRepository.deleteById(id);
    }

    /**
     * Metodo para atualizar um cliente
     * 
     * @param cliente cliente a ser atualizado
     * @return retorna o cliente atualizado
     */
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDto) {

    //Passar o ID para o cliente DTO
    clienteDto.setId(id);
    //Criar um objeto de mapeamento
    ModelMapper mapper = new ModelMapper();
    //Converter o DTO em um cliente 
    Cliente cliente = mapper.map(clienteDto, Cliente.class);
    //Atualizar o cliente no banco de dados
    clienteRepository.save(cliente);
    //Retornar cliente atualizado
     return clienteDto;

    }
}
