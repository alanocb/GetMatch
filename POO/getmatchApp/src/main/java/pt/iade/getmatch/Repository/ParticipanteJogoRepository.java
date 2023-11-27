package pt.iade.getmatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.getmatch.models.ParticipanteJogo;

public interface ParticipanteJogoRepository extends JpaRepository<ParticipanteJogo, Integer> {
}
