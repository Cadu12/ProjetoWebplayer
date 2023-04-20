package br.com.projeto.webplayer.service;

import br.com.projeto.webplayer.model.Diretor;
import br.com.projeto.webplayer.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor procurar_por_nome(String descriao){
        return diretorRepository.findByDescricao(descriao).orElse(null);
    }

    public Diretor salvar(Diretor diretor){
        return diretorRepository.save(diretor);
    }
}
