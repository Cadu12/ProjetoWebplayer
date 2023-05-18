package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.entitiy.Filme;
import br.com.projeto.webplayer.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TestController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/api/filme/lista")
    public List<?> listaFilmes() {
        return filmeService.obter_filmes();
    }

    @GetMapping("/api/filme/lista/{id}")
    public Filme listaFilmes(@PathVariable("id") UUID id) {
        return filmeService.obter_filme_por_id(id);
    }
}
