package com.apibiblioteca.demo.exceptions;

public class LivroNaoCadastradoException extends RuntimeException{

    public LivroNaoCadastradoException(String message) {
        super(message);
    }
}
