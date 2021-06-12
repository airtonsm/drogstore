package com.drogstore.repository;

import com.drogstore.entidades.Pedido;
import com.drogstore.entidades.Pedido_produto;
import com.drogstore.entidades.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoProdutoRepository extends CrudRepository<Pedido_produto, Long> {


}
