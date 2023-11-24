package com.EjercicioSpring.controller;


import com.EjercicioSpring.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@Controller
@RequestMapping ("/noticia")
public class NoticiaController {


    @Autowired
    private  NoticiaService noticiaService;



    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping ("/getAll")
    @ResponseBody
    public String getAll(){

        return noticiaService.getListaNoticias().stream()
                .map(noticia -> noticia.getTitulo() )
                .collect(Collectors.joining(", "));

    }

    @PostMapping("/registro")
    



}
