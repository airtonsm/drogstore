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
        return model;
    }


    @GetMapping(value = "/addprodutopedido/{idproduto}")
    public ModelAndView adicionarProduto(@PathVariable("idproduto") Long idproduto){

        List<Produto> produtoId = produtoServico.ListaPorId(idproduto); //criando lista
        //preciso pegar o id produto selecionado e adicionar na lista
        List<Produto> produtosLista = produtoServico.addProdutos(produtoId.get(idproduto)); // add lista no método addProdutos, para criar lista

        ModelAndView model = new ModelAndView("vendas/pedido");
        model.addObject("produtolista", produtosLista);//adicionar produto a lista de compras

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
