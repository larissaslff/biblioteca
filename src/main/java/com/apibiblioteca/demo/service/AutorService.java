package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Autor;
import com.apibiblioteca.demo.domain.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AutorService {

    public List<Autor> bucarTodosOsAutores();

    public Autor cadastrar(Autor autor);
    public Optional<Autor> buscarPorId(Long id);
    public Autor atualizarAutor(Long id, Autor autor);
    public void deletarAutor(Long id);
}
