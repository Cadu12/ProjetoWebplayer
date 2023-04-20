package br.com.projeto.webplayer.service;

import br.com.projeto.webplayer.model.Genero;
import br.com.projeto.webplayer.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public Genero procurar_por_nome(String descricao){
        return generoRepository.findByDescricao(descricao).orElse(null);
    }

    public Genero salvar(String descricao){
        Genero genero = new Genero();
        genero.setDescricao(descricao);
        return generoRepository.save(genero);
    }

    public long getCount() {
        return generoRepository.count();
    }
}
