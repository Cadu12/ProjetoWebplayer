package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.entitiy.Diretor;
import br.com.projeto.webplayer.entitiy.Filme;
import br.com.projeto.webplayer.service.DiretorService;
import br.com.projeto.webplayer.service.FilmeService;
import br.com.projeto.webplayer.service.GeneroService;
import br.com.projeto.webplayer.web.AtualizarFormData;
import br.com.projeto.webplayer.web.CadastrarFormData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class AtualizarController {
    @Autowired
    private FilmeService filmeService;

    @Autowired
    private DiretorService diretorService;

    @Autowired
    private GeneroService generoService;

    @GetMapping("/atualizar")
    public String pagina(Model model) {
        model.addAttribute("filmes", filmeService.obter_filmes());
        model.addAttribute("generos", generoService.obter_generos());
        model.addAttribute("formData", new AtualizarFormData());

        return "atualizar";
    }

    @GetMapping("/atualizar/{id}")
    public String obter_filme(@PathVariable("id") UUID id, Model model) {
        Filme filme = filmeService.obter_filme_por_id(id);
        if (filme == null){
            model.addAttribute("error_mensagem", "Filme não encontrado.");
            return "atualizar";
        }

        model.addAttribute("generos", generoService.obter_generos());

        AtualizarFormData atualizarFormData = new AtualizarFormData();
        atualizarFormData.setTitulo(filme.getTitulo());
        atualizarFormData.setAno(filme.getAno());
        atualizarFormData.setGenero(filme.getGenero().getId().toString());
        atualizarFormData.setDiretor(filme.getDiretor().getDescricao());

        model.addAttribute("formData", atualizarFormData);
        model.addAttribute("filme", filme);

        return "atualizar";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar_filme(@Valid @ModelAttribute("formData") AtualizarFormData atualizarFormData,
                            @PathVariable("id") UUID id,
                            Model model) {

        Filme filme = filmeService.obter_filme_por_id(id);
        if (filme == null){
            model.addAttribute("error_mensagem", "Filme não encontrado.");
            return "redirect:/atualizar";
        }

        Diretor diretor = diretorService.procurar_por_nome(atualizarFormData.getDiretor());
        if (diretor == null){
            diretor = new Diretor();
            diretor.setDescricao(atualizarFormData.getDiretor().toUpperCase());
            diretor = diretorService.salvar(diretor);
        }

        filme.setTitulo(atualizarFormData.getTitulo());
        filme.setDiretor(diretor);
        filme.setGenero(generoService.procurar_por_id(UUID.fromString(atualizarFormData.getGenero())));
        filme.setAno(atualizarFormData.getAno());

        filmeService.salvar(filme);
        return "redirect:/";
    }
}
