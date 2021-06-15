package com.drogstore.service;

import com.drogstore.entidades.Cliente;
import com.drogstore.entidades.Usuario;
import com.drogstore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Cliente inserir(Cliente obj){
        return repository.save(obj);
    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }
}
