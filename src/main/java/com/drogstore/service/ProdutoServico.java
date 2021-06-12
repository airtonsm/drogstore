package com.drogstore.service;

import com.drogstore.entidades.Produto;
import com.drogstore.entidades.Produto;
import com.drogstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepository repository;

    public Iterable<Produto> listarTodos(){
        return repository.findAll();
    }

    public Produto inserir(Produto obj){
        return repository.save(obj);
    }

    public Optional<Produto> ListaPorId(Long id){
        Optional<Produto> obj = repository.findById(id);
        return obj;
    }

    public List<Produto> listarPorNome(String nome){
        List<Produto> obj = repository.findProdutoByNome(nome);
        return obj;
    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }
}
