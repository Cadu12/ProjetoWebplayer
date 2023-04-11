package br.com.projeto.webplayer.config;

import br.com.projeto.webplayer.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitializeData {
    @Autowired
    private GeneroService generoService;

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
    }
}
