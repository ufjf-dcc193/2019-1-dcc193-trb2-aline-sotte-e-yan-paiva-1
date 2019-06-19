package br.ufjf.dcc193.trabalho_Aline_e_Yan;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliadorRepositorio extends JpaRepository<Avaliador, Long>{
    
    @Query("SELECT a.id FROM Avaliador a WHERE a.email =:email and a.codigoAcesso =:codigoAcesso")
    Long getIdByEmailAndSenha(@Param("email") String email,
     @Param("codigoAcesso") String codigoAcesso);
}
