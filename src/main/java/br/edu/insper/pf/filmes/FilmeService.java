package br.edu.insper.pf.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Optional<Filme> buscarPorId(String id) {
        return filmeRepository.findById(id);
    }

    public void deletarFilme(String id) {
        filmeRepository.deleteById(id);
    }
}
