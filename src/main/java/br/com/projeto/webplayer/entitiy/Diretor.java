package br.com.projeto.webplayer.entitiy;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "tb_diretor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"DESCRICAO"}),
        }
)
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PK_DIRETOR", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "DESCRICAO", length = 64, nullable = false)
    private String descricao;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
