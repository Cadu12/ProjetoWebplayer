package br.com.projeto.webplayer.service;

import br.com.projeto.webplayer.entitiy.Genero;
import br.com.projeto.webplayer.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public Genero procurar_por_nome(String descricao){
        return generoRepository.findByDescricao(descricao).orElse(null);
    }

    public Genero procurar_por_id(UUID id){
        return generoRepository.findById(id).orElse(null);
    }

    public List<?> obter_generos(){
        return generoRepository.findAll();
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
