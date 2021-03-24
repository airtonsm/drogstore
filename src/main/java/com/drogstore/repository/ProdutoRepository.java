package com.drogstore.repository;

import com.drogstore.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("select p from Produto p where p.nome like %?1%")
    List<Produto> findProdutoByNome(String nome);

}
