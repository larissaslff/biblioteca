package com.apibiblioteca.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;
    @JsonIgnore
    @ManyToMany(mappedBy = "livros", cascade = CascadeType.ALL)
    private Set<Autor> autor = new HashSet<>();

    private String ano;

    @Enumerated(EnumType.ORDINAL)
    private OrigemLivro origemLivro;
}
