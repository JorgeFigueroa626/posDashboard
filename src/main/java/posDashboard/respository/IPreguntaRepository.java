package posDashboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posDashboard.model.entity.Examen;
import posDashboard.model.entity.Pregunta;

import java.util.Set;

@Repository
public interface IPreguntaRepository extends JpaRepository<Pregunta, Long> {

    Set<Pregunta> findByExamen(Examen examen);
}
