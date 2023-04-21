package br.com.projeto.webplayer.controller;

import br.com.projeto.webplayer.model.Diretor;
import br.com.projeto.webplayer.model.Filme;
import br.com.projeto.webplayer.service.DiretorService;
import br.com.projeto.webplayer.service.FilmeService;
import br.com.projeto.webplayer.service.GeneroService;
import br.com.projeto.webplayer.web.CadastrarFormData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CadastrarController {
    @Autowired
    private DiretorService diretorService;

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private GeneroService generoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("generos", generoService.obter_generos());
        model.addAttribute("formData", new CadastrarFormData());

        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("formData") CadastrarFormData cadastrarFormData,
                            Model model) {

        Diretor diretor = diretorService.procurar_por_nome(cadastrarFormData.getDiretor());
        if (diretor == null){
            diretor = new Diretor();
            diretor.setDescricao(cadastrarFormData.getDiretor().toUpperCase());
            diretor = diretorService.salvar(diretor);
        }

        Filme filme = new Filme();
        filme.setTitulo(cadastrarFormData.getTitulo().toUpperCase());
        filme.setDiretor(diretor);
        filme.setGenero(generoService.procurar_por_id(UUID.fromString(cadastrarFormData.getGenero())));
        filme.setAno(cadastrarFormData.getAno());
        filme.setCaminho("C:/FILMES/TEST1.MV4");

        filmeService.salvar(filme);

        return "redirect:/";
    }
}
