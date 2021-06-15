package com.drogstore.repository;

import com.drogstore.entidades.Cliente;
import com.drogstore.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT C FROM Cliente C WHERE C.nome LIKE %?1%")
    public List<Cliente> listarPorNome(String nome);

}
