package com.apibiblioteca.demo.controllers;

import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.service.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroServiceImpl service;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro liv, UriComponentsBuilder uriBuilder){
        Livro livro = service.cadastrar(liv);
        URI location = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(location).body(service.cadastrar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscarLivros(){
        return ResponseEntity.ok().body(service.bucarTodosOsLivros());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Livro>> buscarLivrosPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro){
        return ResponseEntity.ok().body(service.atualizarLivro(id, livro));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        service.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
