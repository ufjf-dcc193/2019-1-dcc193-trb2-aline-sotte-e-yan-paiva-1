package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDeConhecimentoRepositorio 
    extends JpaRepository<AreaDeConhecimento, Long>{ 
    List<AreaDeConhecimento> findByIdAvaliador(Avaliador idAvaliador);
    List<AreaDeConhecimento> findByIdTrabalho(Trabalho idTrabalho);
}
