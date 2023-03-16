package com.apibiblioteca.demo.repositories;

import com.apibiblioteca.demo.domain.Autor;
import com.apibiblioteca.demo.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
