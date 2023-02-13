package com.jw_mecanica.view.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
<<<<<<< Updated upstream


=======
import java.util.stream.Stream;

import org.apache.catalina.mapper.Mapper;
>>>>>>> Stashed changes
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< Updated upstream

=======
import com.jw_mecanica.models.Cliente;
import com.jw_mecanica.service.ClienteService;
>>>>>>> Stashed changes
import com.jw_mecanica.shared.ClienteDTO;
import com.jw_mecanica.view.model.CLienteRequest;
import com.jw_mecanica.view.model.ClienteResponse;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // #region Métodos

    /**
     * Método que retorna uma lista de clientes.*
     * 
     * @return Lista de objetos ClienteResponse.
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        // Utiliza o stream e o map para aplicar o método map do ModelMapper para cada
        // objeto da lista de clientes.
        ModelMapper mapper = new ModelMapper();
        List<ClienteResponse> resposta = clientes.stream().map(cliente -> mapper.map(cliente, ClienteResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteResponse>> getClienteID(@PathVariable long id) {
        Optional<ClienteDTO> dto = clienteService.getClienteID(id);
        ClienteResponse cliente = new ModelMapper().map(dto.get(), ClienteResponse.class);
        return new ResponseEntity<>(Optional.of(cliente), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody CLienteRequest clienteReq) {
        ModelMapper mapper = new ModelMapper();
        ClienteDTO clienteDto = mapper.map(clienteReq, ClienteDTO.class);
        clienteDto = clienteService.cadastrarCliente(clienteDto);
        return new ResponseEntity<ClienteResponse>(mapper.map(clienteDto, ClienteResponse.class), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT, null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> AtualizarCliente(@PathVariable long id,
            @RequestBody CLienteRequest clienteReq) {
        ModelMapper mapper = new ModelMapper();
        ClienteDTO clienteDto = mapper.map(clienteReq, ClienteDTO.class);
       clienteDto = clienteService.atualizarCliente(id, clienteDto);
        return new ResponseEntity<>(
            mapper.map(clienteDto,ClienteResponse.class),
             HttpStatus.OK);

    }

    // #endregion
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
