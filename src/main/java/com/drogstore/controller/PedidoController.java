package com.drogstore.controller;

import com.drogstore.entidades.*;
import com.drogstore.repository.PedidoProdutoRepository;
import com.drogstore.repository.ProdutoRepository;
import com.drogstore.service.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PedidoController {

    @Autowired
    ProdutoServico produtoServico;

    @Autowired
    PedidoProdutoRepository pedidoRepository;

    @GetMapping(value = "/pedido")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/pedido");

        model.addObject("pedido", new Pedido());
        model.addObject("cliente", new Cliente());
        model.addObject("usuario", new Usuario());




        return model;
    }



    @GetMapping(value = "/addprodutopedido/{idproduto}")
    public ModelAndView adicionarProduto(@PathVariable("idproduto") Long idproduto){
        ModelAndView model = new ModelAndView("vendas/pedido");
        return model;
    }

    @GetMapping("**/pesquisarProduto")
    public ModelAndView pesquisar(@RequestParam("medPesquisa") String medPesquisa){
        List<Produto> produtos;
        ModelAndView model = new ModelAndView("vendas/pedido");
        produtos = produtoServico.listarPorNome(medPesquisa);
        model.addObject("produtos", produtos);

        return model;
    }
}
