package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class AreaDeConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricaoTextual;
    @OneToOne
    private Trabalho idTrabalho;
    @ManyToOne
    private Avaliador idAvaliador;
    
    public AreaDeConhecimento(@NotBlank String titulo,
     @NotBlank String descricaoTextual) {
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
    }

    public AreaDeConhecimento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricaoTextual() {
        return descricaoTextual;
    }

    public void setDescricaoTextual(String descricaoTextual) {
        this.descricaoTextual = descricaoTextual;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + ", DescricaoTextual=" + descricaoTextual + ", id="+ id;
    }
}