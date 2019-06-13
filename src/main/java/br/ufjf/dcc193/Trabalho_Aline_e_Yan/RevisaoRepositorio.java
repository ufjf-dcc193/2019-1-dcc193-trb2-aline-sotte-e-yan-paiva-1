package  br.ufjf.dcc193.Trabalho_Aline_e_Yan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisaoRepositorio extends JpaRepository<Revisao, Long>{

}
