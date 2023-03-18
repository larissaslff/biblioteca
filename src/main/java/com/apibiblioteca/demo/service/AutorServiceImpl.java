package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Autor;
import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.exceptions.LivroNaoCadastradoException;
import com.apibiblioteca.demo.repositories.AutorRepository;
import com.apibiblioteca.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Override
    public Autor cadastrar(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public List<Autor> bucarTodosOsAutores(){
        return repository.findAll();
    }

    @Override
    public Optional<Autor> buscarPorId(Long id) {
        Optional<Autor> autor = repository.findById(id);
        if(autor.isPresent()){
            return autor;
        }
        throw new LivroNaoCadastradoException("Autor não cadastrado!") ;
    }
    @Override
    public Autor atualizarAutor(Long id, Autor autor) {

        buscarPorId(id);
        autor.setId(id);
        return cadastrar(autor);
    }

    @Override
    public void deletarAutor(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Autor cadastrarLivronoAutor(Long idAutor, Long idLivro) {
        Set<Livro> livroSet = null;
        Autor autor = repository.findById(idAutor).get();
        Livro livro = livroRepository.findById(idLivro).get();
        livroSet = autor.getLivros();
        livroSet.add(livro);
        autor.setLivros(livroSet);
        return repository.save(autor);
    }
}
