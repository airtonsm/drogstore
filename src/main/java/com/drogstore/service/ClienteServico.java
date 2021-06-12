package com.drogstore.service;

import com.drogstore.entidades.Cliente;
import com.drogstore.entidades.Usuario;
import com.drogstore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepository repository;

    public Iterable<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Cliente inserir(Cliente obj){
        return repository.save(obj);
    }

    public Optional<Cliente> listarPorId(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj;
    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }
}
