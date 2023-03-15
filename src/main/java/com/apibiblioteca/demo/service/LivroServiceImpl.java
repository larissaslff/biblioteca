package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl {

    @Autowired
    LivroRepository repository;

    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> bucarTodosOsLivros(){
        return repository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        Optional<Livro> livroJaCadastrado = buscarPorId(id);
        if(livroJaCadastrado.isPresent()){
            livro.setId(id);
            cadastrar(livro);
            return livro;
        }
        throw new RuntimeException();
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }
}
