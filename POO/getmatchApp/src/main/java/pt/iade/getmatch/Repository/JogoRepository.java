package pt.iade.getmatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.getmatch.models.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
}
