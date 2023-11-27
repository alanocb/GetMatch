package pt.iade.getmatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iade.getmatch.models.Modalidade;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {
}
