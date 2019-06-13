package br.ufjf.dcc193.Trabalho_Aline_e_Yan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Avaliador {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long Id;
    
   @NotBlank
   private String nomeCompleto;
   
   @Email
   @NotBlank
   private String email; 
   
   @NotBlank
   private String codigoAcesso;

   
    public Avaliador (){}


    public Avaliador(String nomeCompleto, String email){
        this.email=email;
        this.nomeCompleto=nomeCompleto;
    }
   /**
    * @return the id
    */
   public Long getId() {
       return Id;
   }

   /**
    * @return the codigoAcesso
    */
   public String getCodigoAcesso() {
       return codigoAcesso;
   }/**
    * @return the email
    */
   public String getEmail() {
       return email;
   }/**
    * @return the nomeCompleto
    */
   public String getNomeCompleto() {
       return nomeCompleto;
   }

   /**
    * @param codigoAcesso the codigoAcesso to set
    */
   public void setCodigoAcesso(String codigoAcesso) {
       this.codigoAcesso = codigoAcesso;
   }/**
    * @param email the email to set
    */
   public void setEmail(String email) {
       this.email = email;
   }/**
    * @param id the id to set
    */
   public void setId(Long id) {
       Id = id;
   }/**
    * @param nomeCompleto the nomeCompleto to set
    */
   public void setNomeCompleto(String nomeCompleto) {
       this.nomeCompleto = nomeCompleto;
   }

    @Override
    public String toString() {
        return "Avaliador [Id=" + Id + ", codigoAcesso=" + codigoAcesso + ", email=" + email + ", nomeCompleto="
                + nomeCompleto + "]";
    }

   
}