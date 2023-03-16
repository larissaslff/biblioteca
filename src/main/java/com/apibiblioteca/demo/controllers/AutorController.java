package com.apibiblioteca.demo.controllers;

import com.apibiblioteca.demo.domain.Autor;
import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.service.AutorService;
import com.apibiblioteca.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor, UriComponentsBuilder uriBuilder){
        Autor autor1 = service.cadastrar(autor);
        URI location = uriBuilder.path("/autores/{id}").buildAndExpand(autor1.getId()).toUri();
        return ResponseEntity.created(location).body(service.cadastrar(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> buscarAutores(){
        return ResponseEntity.ok().body(service.bucarTodosOsAutores());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Autor>> buscarAutoresPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autor){
        return ResponseEntity.ok().body(service.atualizarAutor(id, autor));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id) {
        service.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

}
