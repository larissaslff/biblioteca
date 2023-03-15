package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl {

    @Autowired
    LivroRepository repository;

    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }
}
