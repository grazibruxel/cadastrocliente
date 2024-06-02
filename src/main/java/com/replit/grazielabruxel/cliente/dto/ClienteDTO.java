package com.replit.grazielabruxel.cliente.dto;

import com.replit.grazielabruxel.cliente.dao.Cliente;
import jakarta.persistence.*;

public class ClienteDTO {
    private String codigo;
    private String metodo;
    private String mensagem;
    private Cliente cliente;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
