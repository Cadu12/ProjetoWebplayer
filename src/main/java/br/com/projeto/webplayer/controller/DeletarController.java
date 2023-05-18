package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.entitiy.Filme;
import br.com.projeto.webplayer.service.FilmeService;
import br.com.projeto.webplayer.web.DeletarFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class DeletarController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/deletar")
    public String pagina(Model model) {
        model.addAttribute("filmes", filmeService.obter_filmes());
        model.addAttribute("formData", new DeletarFormData());

        return "deletar";
    }

    @GetMapping("/deletar/{id}")
    public String obter_filme(@PathVariable("id") UUID id, Model model) {
        Filme filme = filmeService.obter_filme_por_id(id);
        if (filme == null){
            model.addAttribute("error_mensagem", "Filme não encontrado.");
            return "deletar";
        }

        DeletarFormData deletarFormData = new DeletarFormData();
        deletarFormData.setTitulo(filme.getTitulo());
        deletarFormData.setAno(filme.getAno());
        deletarFormData.setGenero(filme.getGenero().getDescricao());
        deletarFormData.setDiretor(filme.getDiretor().getDescricao());

        model.addAttribute("formData", deletarFormData);
        model.addAttribute("filme", filme);

        return "deletar";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar_filme(@PathVariable("id") UUID id,
                            Model model) {

        Filme filme = filmeService.obter_filme_por_id(id);
        if (filme == null){
            model.addAttribute("error_mensagem", "Filme não encontrado.");
            return "redirect:/deletar";
        }

        filmeService.deletar(filme);
        return "redirect:/";
    }
}
