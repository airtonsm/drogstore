package com.drogstore.service;

import com.drogstore.entidades.Pedido;
import com.drogstore.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class PedidoServico {

    @Autowired
    PedidoProdutoRepository repository;

    public  Pedido salvar(Pedido pedido){
        Instant agora = Instant.now();
        pedido.setData(agora);
        return  repository.save(pedido);
    }

}
