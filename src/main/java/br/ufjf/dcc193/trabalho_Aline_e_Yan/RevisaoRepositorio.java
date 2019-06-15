package  br.ufjf.dcc193.trabalho_Aline_e_Yan;

import br.ufjf.dcc193.trabalho_Aline_e_Yan.Revisao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisaoRepositorio extends JpaRepository<Revisao, Long>{

}
