package  br.ufjf.dcc193.trabalho_Aline_e_Yan;

import br.ufjf.dcc193.trabalho_Aline_e_Yan.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepositorio extends JpaRepository<Trabalho, Long>{

}
