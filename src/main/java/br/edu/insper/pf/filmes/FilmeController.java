package br.edu.insper.pf.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getFilmes() {
        return filmeService.listarFilmes();
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme) {
        return filmeService.salvarFilme(filme);
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilme(@PathVariable String id) {
        return filmeService.buscarPorId(id);
    }

    @GetMapping("/{id}")
    public void deletarFilme(@PathVariable String id){
        filmeService.deletarFilme(id);
    }
}
