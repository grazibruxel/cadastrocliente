package com.replit.grazielabruxel.cliente.services;

import com.replit.grazielabruxel.cliente.repository.ClienteRepository;
import com.replit.grazielabruxel.cliente.dao.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    
    ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> listarClientes() {
        return this.clienteRepository.findAll();
    }
    
    public Cliente salvarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void deletarCliente(int id) {
        this.clienteRepository.deleteById(id);
    }
    
    public Cliente buscarCliente(int id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    public int nextId() {
        return Long.valueOf(this.clienteRepository.count() + 1).intValue();
    }

    public Cliente getClienById(int id) {
        return this.clienteRepository.findById(id).orElse(null);
    }
}
