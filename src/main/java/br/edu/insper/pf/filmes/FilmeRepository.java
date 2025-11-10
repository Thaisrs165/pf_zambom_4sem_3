package br.edu.insper.pf.filmes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class FilmeRepository extends JpaRepository<Filme, Integer> {
}
