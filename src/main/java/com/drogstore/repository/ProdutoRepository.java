package com.drogstore.repository;

import com.drogstore.entidades.Pedido_produto;
import com.drogstore.entidades.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("select p from Produto p where p.nome like %?1%")
    List<Produto> findProdutoByNome(String nome);




}
