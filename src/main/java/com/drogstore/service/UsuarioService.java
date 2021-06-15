package com.drogstore.service;

import com.drogstore.entidades.Usuario;
import com.drogstore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Iterable<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario inserir(Usuario obj){
        return repository.save(obj);
    }

//    public List<Usuario> ListaPorId(Long id){
//        List<Usuario> obj = repository.listarPorId(id);
//        return obj;
//    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }


}
