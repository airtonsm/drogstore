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

    public List<Produto> listarTodos(){
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


    List<Produto> produtosLista = new ArrayList<>();
    public List<Produto> addProdutos(Produto obj){
        produtosLista.add(obj);
        return produtosLista;
    }
}
