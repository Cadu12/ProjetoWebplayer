package br.com.projeto.webplayer.service;

import br.com.projeto.webplayer.model.Filme;
import br.com.projeto.webplayer.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<?> obter_filmes(){
        return filmeRepository.findAll();
    }

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }
}
