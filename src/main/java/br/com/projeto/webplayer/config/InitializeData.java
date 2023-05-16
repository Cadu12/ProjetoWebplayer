package br.com.projeto.webplayer.config;

import br.com.projeto.webplayer.service.DiretorService;
import br.com.projeto.webplayer.service.FilmeService;
import br.com.projeto.webplayer.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitializeData {
    @Autowired
    private GeneroService generoService;

    @Autowired
    private DiretorService diretorService;

    @Autowired
    private FilmeService filmeService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent() {
        if (generoService.getCount() == 0){
            generoService.salvar("AÇÃO");
            generoService.salvar("ANIMAÇÃO");
            generoService.salvar("AVENTURA");
            generoService.salvar("COMÉDIA");
            generoService.salvar("CRIME");
            generoService.salvar("DOCUMENTÁRIO");
            generoService.salvar("DRAMA");
            generoService.salvar("ÉPICO/HISTÓRICO");
            generoService.salvar("FAMÍLIA/INFANTIL");
            generoService.salvar("FANTASIA");
            generoService.salvar("FICÇÃO CIENTÍFICA");
            generoService.salvar("GUERRA");
            generoService.salvar("MISTÉRIO/SUSPENSE");
            generoService.salvar("MUSICAL/DANÇA");
            generoService.salvar("ROMANCE");
            generoService.salvar("TERROR");
        }

        //Diretor diretor = new Diretor();
        //diretor.setDescricao("CARLOS OLIVEIRA");
        //diretorService.salvar(diretor);

        /*Diretor diretor = diretorService.procurar_por_nome("CARLOS OLIVEIRA");
        Filme filme = new Filme();
        filme.setDiretor(diretor);
        filme.setTitulo("TESTE 2");
        filme.setAno(2023);
        filme.setTrailer(false);
        filme.setGenero(generoService.procurar_por_nome("AÇÃO"));
        filme.setCaminho("/caminho2.mv4");
        filmeService.salvar(filme);*/
    }
}
