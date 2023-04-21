package br.com.projeto.webplayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtualizarController {
    @GetMapping("/atualizar")
    public String atualizar(Model model) {
        return "atualizar";
    }
}
