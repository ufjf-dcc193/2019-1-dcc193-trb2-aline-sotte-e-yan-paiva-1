package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class AreaDeConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(0)
    @Max(5)
    private Integer titulo;

    @NotBlank
    private String descricaoTextual;
    @OneToMany(mappedBy ="idAreaDeConhecimento", cascade = CascadeType.ALL)
    private List<Trabalho> idTrabalho;
    @ManyToOne
    private Avaliador idAvaliador;
    
    public AreaDeConhecimento(@NotBlank Integer titulo,
     @NotBlank String descricaoTextual) {
        this();
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
    }

    public AreaDeConhecimento() {
        this.titulo = 0;
        idTrabalho = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTitulo() {
        return titulo;
    }

    public void setTitulo(Integer titulo) {
        this.titulo = titulo;
      //  return this;
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

    public List<Trabalho> getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(List<Trabalho> idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public Avaliador getIdAvaliador() {
        return idAvaliador;
    }

    public void setIdAvaliador(Avaliador idAvaliador) {
        this.idAvaliador = idAvaliador;
    }
}