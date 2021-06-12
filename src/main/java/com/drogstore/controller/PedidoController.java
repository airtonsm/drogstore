package com.drogstore.controller;

import com.drogstore.entidades.Pedido;
import com.drogstore.entidades.Pedido_produto;
import com.drogstore.entidades.Produto;
import com.drogstore.repository.PedidoProdutoRepository;
import com.drogstore.repository.ProdutoRepository;
import com.drogstore.service.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class PedidoController {

    @Autowired
    ProdutoServico produtoServico;

    PedidoProdutoRepository pedidoRepository;

    @GetMapping(value = "/pedido")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/pedido");
        return model;
    }


    @GetMapping(value = "/addProduto")
    public ModelAndView salvar(Pedido_produto pedidoProduto, Pedido pedido, Produto produto){
        ModelAndView model = new ModelAndView("vendas/pedido");
        Set<Produto> produtosLista = produtoServico.addProdutos(produto);
        model.addObject("produtos", produtosLista);

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
