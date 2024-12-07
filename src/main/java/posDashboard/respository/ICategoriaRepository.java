package posDashboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posDashboard.model.entity.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
