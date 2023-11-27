package pt.iade.getmatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iade.getmatch.models.Campo;

import java.util.Optional;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Integer> {
    Optional<Campo> findByTelefone(int telefone);
}