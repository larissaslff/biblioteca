package com.apibiblioteca.demo.service;

import com.apibiblioteca.demo.domain.Livro;
import com.apibiblioteca.demo.exceptions.LivroNaoCadastradoException;
import com.apibiblioteca.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Override
    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public List<Livro> bucarTodosOsLivros(){
        return repository.findAll();
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()){
            return livro;
        }
        throw new LivroNaoCadastradoException("Livro não cadastrado!") ;
    }
    @Override
    public Livro atualizarLivro(Long id, Livro livro) {
        buscarPorId(id);
        livro.setId(id);
        return cadastrar(livro);
    }
    @Override
    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }
}
