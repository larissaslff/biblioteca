package com.apibiblioteca.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable( name = "livros_autores",
            joinColumns = @JoinColumn (name = "autor_id"),
            inverseJoinColumns = @JoinColumn (name = "livro_id")
    )
    private Set<Livro> livros = new HashSet<>();

}
