package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

/**
 * Trabalho
 */
@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricaoTextual;

    @NotBlank
    private String url;
    @ManyToOne
    private AreaDeConhecimento idAreaDeConhecimento;

    @OneToMany(mappedBy = "idTrabalho", cascade = CascadeType.ALL)
    private List<Revisao> revisao;

    public Trabalho(@NotBlank String titulo, @NotBlank String descricaoTextual, @NotBlank String url,
            @NotBlank AreaDeConhecimento areaConhecimento) {
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
        this.url = url;
        this.idAreaDeConhecimento = areaConhecimento;
    }

    public Trabalho() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AreaDeConhecimento getAreaConhecimento() {
        return idAreaDeConhecimento;
    }

    public void setAreaConhecimento(AreaDeConhecimento areaConhecimento) {
        this.idAreaDeConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "Trabalho [areaConhecimento=" + idAreaDeConhecimento + ", descricaoTextual=" + descricaoTextual + ", id="
                + id + ", titulo=" + titulo + ", url=" + url + "]";
    }
}