package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("filmes", filmeService.obter_filmes());
        return "index";
    }
}
