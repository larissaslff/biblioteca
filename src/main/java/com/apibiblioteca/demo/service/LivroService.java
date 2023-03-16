package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LivroService {

    public List<Livro> bucarTodosOsLivros();

    public Livro cadastrar(Livro livro);
    public Optional<Livro> buscarPorId(Long id);
    public Livro atualizarLivro(Long id, Livro livro);
    public void deletarLivro(Long id);
}
