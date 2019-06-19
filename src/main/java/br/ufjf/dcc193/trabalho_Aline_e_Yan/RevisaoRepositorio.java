package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import br.ufjf.dcc193.trabalho_Aline_e_Yan.Revisao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisaoRepositorio extends JpaRepository<Revisao, Long>{
    /*@Query("DELETE r FROM Revisao r WHERE idTrabalho=:idTrab")
    void removeByIdTrabalho(@Param("idTrab") Trabalho idTrab);
   */
  List<Revisao> findByIdTrabalho(Trabalho idTrabalho); 
    
}
