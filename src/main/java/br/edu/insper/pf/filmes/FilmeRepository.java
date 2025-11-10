package br.edu.insper.pf.filmes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface FilmeRepository extends MongoRepository<Filme, Integer> {
}
