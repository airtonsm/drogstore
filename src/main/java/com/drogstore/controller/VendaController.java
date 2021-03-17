package com.drogstore.controller;

import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VendaController {

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/vendedor");
        return model;
    }

}
