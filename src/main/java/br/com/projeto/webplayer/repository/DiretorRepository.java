package br.com.projeto.webplayer.repository;

import br.com.projeto.webplayer.entitiy.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, UUID> {
    Optional<Diretor> findByDescricao(String descricao);
}