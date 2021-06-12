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

    public Optional<Produto> ListaPorId(Long id){
        Optional<Produto> obj = repository.findById(id);
        return obj;
    }

    public List<Produto>  listarPorNome(String nome){
        List<Produto> objeto = repository.findProdutoByNome(nome);
        return objeto;
    }

    public void deletarPorId(long id){
        repository.deleteById(id);
    }


    Set<Produto> produtos = new HashSet<>();
    public Set<Produto> addProdutos(Produto obj){
        produtos.add(obj);
        return produtos;
    }
}
