package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultarController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/")
    public String pagina(Model model) {
        return "redirect:/consultar";
    }

    @GetMapping("/consultar")
    public String consultar(Model model) {
        model.addAttribute("filmes", filmeService.obter_filmes());
        return "consultar";
    }
}
