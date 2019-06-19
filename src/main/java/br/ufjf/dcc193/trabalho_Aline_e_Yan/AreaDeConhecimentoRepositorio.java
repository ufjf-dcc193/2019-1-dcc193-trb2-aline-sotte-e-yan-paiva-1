package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import br.ufjf.dcc193.trabalho_Aline_e_Yan.AreaDeConhecimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDeConhecimentoRepositorio 
    extends JpaRepository<AreaDeConhecimento, Long>{ 
    List<AreaDeConhecimento> findByIdAvaliador(Avaliador idAvaliador);
    List<AreaDeConhecimento> get
    List<AreaDeConhecimento> findByIdTrabalho(Trabalho idTrabalho);
}
