package br.ufjf.dcc193.Trabalho_Aline_e_Yan;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Revisao
 */
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idAvaliador;

    private Long idTrabalho;

    @Min(0)
    @Max(100)
    @NotBlank
    private Float nota;

    private String descricaoOpcional;

    @NotBlank
    private String Status;

    public Revisao() {
    }

    public Revisao(@Min(0) @Max(100) @NotBlank Float nota, String descricaoOpcional, @NotBlank String status) {
        this.nota = nota;
        this.descricaoOpcional = descricaoOpcional;
        Status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAvaliador() {
        return idAvaliador;
    }

    public void setIdAvaliador(Long idAvaliador) {
        this.idAvaliador = idAvaliador;
    }

    public Long getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(Long idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getDescricaoOpcional() {
        return descricaoOpcional;
    }

    public void setDescricaoOpcional(String descricaoOpcional) {
        this.descricaoOpcional = descricaoOpcional;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Revisao [Status=" + Status + ", descricaoOpcional=" + descricaoOpcional + ", id=" + id
                + ", idAvaliador=" + idAvaliador + ", idTrabalho=" + idTrabalho + ", nota=" + nota + "]";
    }
   

    
    
    
}