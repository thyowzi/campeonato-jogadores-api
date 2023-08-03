package players.register.api.jogador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{

	Page<Jogador> findAllByAtivoTrue(Pageable paginacao);

}
