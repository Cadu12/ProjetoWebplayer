package br.com.projeto.webplayer.service;

import br.com.projeto.webplayer.entitiy.Filme;
import br.com.projeto.webplayer.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme obter_filme_por_id(UUID uuid){
        return filmeRepository.findById(uuid).orElse(null);
    }

    public List<?> obter_filmes(){
        return filmeRepository.findAll();
    }

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }
}
