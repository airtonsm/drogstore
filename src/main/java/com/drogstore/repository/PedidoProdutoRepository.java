package com.drogstore.repository;

import com.drogstore.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends CrudRepository<Pedido, Long> {



}
