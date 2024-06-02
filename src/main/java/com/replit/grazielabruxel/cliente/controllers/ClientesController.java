package com.replit.grazielabruxel.cliente.controllers;

import com.replit.grazielabruxel.cliente.dao.Cliente;
import com.replit.grazielabruxel.cliente.dto.ClienteDTO;
import com.replit.grazielabruxel.cliente.services.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClientesController
{
    private ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/criar", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteDTO> criar(@RequestBody Cliente requestBody) {
        requestBody.setId(this.clienteService.nextId());
        requestBody.setNome(requestBody.getNome());

        clienteService.salvarCliente(requestBody);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCodigo("INSERED");
        clienteDTO.setMetodo("POST");
        clienteDTO.setCliente(requestBody);

        return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);
    }

    @PutMapping(value = "/atualizar/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteDTO> atualizar(@RequestBody Cliente requestBody, @PathVariable("id") String id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setMetodo("PUT");

        if (id == null || id.isEmpty()) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("ID não informado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteDTO);
        }
        
        Cliente cliente = this.clienteService.getClienById(Integer.parseInt(id));

        if (cliente == null) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("Cliente não encontrado " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteDTO);
        }

        cliente.setNome(requestBody.getNome());
        clienteService.salvarCliente(cliente);

        clienteDTO.setCodigo("ALTERED");
        clienteDTO.setCliente(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);
    }

    @DeleteMapping(value = "/deletar/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteDTO> deletar(@PathVariable("id") String id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setMetodo("DEL");

        if (id == null || id.isEmpty()) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("ID não informado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteDTO);
        }

        Cliente cliente = this.clienteService.getClienById(Integer.parseInt(id));

        if (cliente == null) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("Cliente não encontrado " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteDTO);
        }

        clienteDTO.setCodigo("DELETED");
        clienteDTO.setCliente(cliente);

        clienteService.deletarCliente(Integer.parseInt(id));

        return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteDTO> get(@PathVariable("id") String id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setMetodo("GET");

        if (id == null || id.isEmpty()) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("ID não informado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteDTO);
        }

        Cliente cliente = this.clienteService.getClienById(Integer.parseInt(id));

        if (cliente == null) {
            clienteDTO.setCodigo("ERRO");
            clienteDTO.setMensagem("Cliente não encontrado " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteDTO);
        }

        clienteDTO.setCodigo("GETTED");
        clienteDTO.setCliente(cliente);
    
        return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);
    }

    @GetMapping(value = "/listar", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Cliente>> listarTudo() {
        List<Cliente> list = clienteService.listarClientes();
        return ResponseEntity.ok(list);
    }
}
