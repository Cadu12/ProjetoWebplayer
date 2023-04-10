package br.com.projeto.webplayer.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "tb_filme",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"CAMINHO"}),
        }
)
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PK_GENERO", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "CAMINHO", length = 256, nullable = false)
    private String caminho;

    @Column(name = "TITULO", length = 128, nullable = false)
    private String titulo;

    @Column(name = "ANO", length = 4, nullable = false)
    private int ano;

    @OneToOne
    @JoinColumn(name = "ID_FK_DIRETOR", referencedColumnName = "ID_PK_DIRETOR", nullable = false)
    private Diretor diretor;

    @OneToOne
    @JoinColumn(name = "ID_FK_GENERO", referencedColumnName = "ID_PK_GENERO", nullable = false)
    private Genero genero;

    public UUID getId() {
        return id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
