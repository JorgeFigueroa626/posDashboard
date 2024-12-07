package posDashboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posDashboard.model.entity.Categoria;
import posDashboard.model.entity.Examen;

import java.util.List;

@Repository
public interface IExamenRepository  extends JpaRepository<Examen, Long> {

    List<Examen> findByCategoria(Categoria categoria);

    List<Examen> findByState(Boolean estado);

    List<Examen> findByCategoriaAndState(Categoria categoria, Boolean estado);
}
