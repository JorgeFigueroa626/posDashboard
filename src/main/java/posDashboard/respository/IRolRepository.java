package posDashboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posDashboard.model.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
}
