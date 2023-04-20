package br.com.projeto.webplayer.repository;

import br.com.projeto.webplayer.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, UUID> {
    Optional<Genero> findByDescricao(String descricao);
}