package com.replit.grazielabruxel.cliente.repository;


import com.replit.grazielabruxel.cliente.dao.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
