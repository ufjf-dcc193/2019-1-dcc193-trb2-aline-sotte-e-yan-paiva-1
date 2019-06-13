package br.ufjf.dcc193.Trabalho_Aline_e_Yan;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Trabalho
 */
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

    @NotBlank
    private String areaConhecimento;

    public Trabalho(@NotBlank String titulo, @NotBlank String descricaoTextual, @NotBlank String url,
            @NotBlank String areaConhecimento) {
        this.titulo = titulo;
        this.descricaoTextual = descricaoTextual;
        this.url = url;
        this.areaConhecimento = areaConhecimento;
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

    public String getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "Trabalho [areaConhecimento=" + areaConhecimento + ", descricaoTextual=" + descricaoTextual + ", id="
                + id + ", titulo=" + titulo + ", url=" + url + "]";
    }
}