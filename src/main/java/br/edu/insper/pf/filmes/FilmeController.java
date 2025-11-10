package br.edu.insper.pf.filmes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }


    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarFilmes();
    }


    @GetMapping("/{id}")
    public Filme getFilme(@PathVariable String id) {
        return filmeService.buscarPorId(id).orElse(null);
    }


    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeService.salvarFilme(filme);
    }


    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable String id) {
        filmeService.deletarFilme(id);
    }
}
