package com.apibiblioteca.demo.controllers;

import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.service.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private LivroServiceImpl service;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        return ResponseEntity.ok(service.cadastrar(livro));
    }
}
