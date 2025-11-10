package br.edu.insper.pf.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getFilmes() {
        return filmeService.getFilmes();
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme) {
        return filmeService.createFilme(filme);
    }

    @GetMapping("/{id}")
    public Filme getFilme(@PathVariable Integer id) {
        return filmeService.getFilme(id);
    }
}
