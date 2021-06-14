package com.drogstore.service;

import com.drogstore.entidades.Produto;
import com.drogstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Produto>  listarPorNome(String nome){
        List<Produto> objeto = repository.findProdutoByNome(nome);
        return objeto;
    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }


    Set<Optional<Produto>> produtosLista = new HashSet<>();

    public Set<Optional<Produto>> addProdutos(Optional<Produto> obj){
        produtosLista.add(obj);
        return produtosLista;
    }
}
